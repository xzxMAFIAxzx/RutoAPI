package dao.impl;

import bean.Nationality;
import bean.User;
import dao.inter.AbstractDAO;
import dao.inter.UserDaoInter;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class UserDaoImpl extends AbstractDAO implements UserDaoInter {

    private User getUser (ResultSet rs)throws Exception{
        int id = rs.getInt("id");
        String name = rs.getString("name");
        String surname = rs.getString("surname");
        String phone = rs.getString("phone");
        String email = rs.getString("email");
        int nationalityId = rs.getInt("nationality_id");
        int birthplaceId = rs.getInt("birthplace_id");
        String nationalityStr = rs.getString("nationality");
        String birthplaceStr = rs.getString("birthplace");
        Date birthdate = rs.getDate("birthdate");

        Nationality nationality = new Nationality(nationalityId,nationalityStr,null);
        Nationality birthplace = new Nationality(birthplaceId,birthplaceStr,null);

        return new User(id, name, surname, phone, email,birthdate,nationality,birthplace);
    }


    @Override
    public List<User> getAll() {
        List<User> result = new ArrayList<>();
        try (Connection c = connect()) {
            Statement stmt = c.createStatement();
            stmt.execute("select "
                    +" u.*,"
                    +" n.name as nationality,"
                    +" c.country_name as birthplace from user u"
                    +" left join nationality n on u.nationality_id = n.id"
                    +" left join nationality c on u.birthplace_id = c.id");
            ResultSet rs = stmt.getResultSet();

            while (rs.next()) {
               User u = getUser(rs);

               result.add(u);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;
    }

    @Override
    public User getById(int userId) {
        User result = null;
        try (Connection c = connect()) {
            Statement stmt = c.createStatement();
            stmt.execute("select"
                    +"u.*,"
                    +"n.name as nationality,"
                    +"c.country_name as birthplace from user u"
                    +"left join nationality n on u.nationality_id = n.id"
                    +"left join nationality c on u.birthplace_id = c.id"+userId);
            ResultSet rs = stmt.getResultSet();

            while (rs.next()) {
                result= getUser(rs);
                result = getUser(rs);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;
    }


    @Override
    public boolean updateUser(User u) {
        try (Connection c = connect()) {
            PreparedStatement stmt = c.prepareStatement("update user set name = ?,surname = ?,phone = ?,email = ? where id = ?");
            stmt.setString(1, u.getName());
            stmt.setString(2, u.getSurname());
            stmt.setString(3, u.getPhone());
            stmt.setString(4, u.getEmail());
            stmt.setInt(5, u.getId());
            return stmt.execute();
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean addUser(User u) {
        try (Connection c = connect()) {
            PreparedStatement stmt = c.prepareStatement("insert into user (name,surname,phone,email)values(?,?,?,?)");
            stmt.setString(1, u.getName());
            stmt.setString(2, u.getSurname());
            stmt.setString(3, u.getPhone());
            stmt.setString(4, u.getEmail());
            return stmt.execute();
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean removeUser(int id) {
        try (Connection c = connect()) {
            Statement stmt = c.createStatement();
            return stmt.execute("delete from user where id =" + id);
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

}


