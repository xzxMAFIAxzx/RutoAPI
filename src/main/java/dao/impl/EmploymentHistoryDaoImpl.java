package dao.impl;

import dao.inter.AbstractDAO;
import dao.inter.EmploymentHistoryDaoInter;
import entity.EmploymentHistory;
import entity.Skill;
import entity.User;
import entity.UserSkill;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class EmploymentHistoryDaoImpl extends AbstractDAO implements EmploymentHistoryDaoInter {

    private EmploymentHistory getEmploymentHistory (ResultSet rs)throws Exception{
        String header = rs.getString("header");
        String jobDescription = rs.getString("job_description");
        Date beginDate = rs.getDate("begin_date");
        Date endDate = rs.getDate("end_date");
        int userId = rs.getInt("user_id");
        EmploymentHistory emp = new EmploymentHistory(null,header,beginDate,endDate,jobDescription,new User(userId));

        return emp;
    }
    @Override
    public List<EmploymentHistory> getAllEmploymentHistoryByUserId(int userId) {
        List<EmploymentHistory> result = new ArrayList<>();
        try (Connection c = connect()) {
            PreparedStatement stmt = c.prepareStatement("select * from employment_history where user_id =?");
            stmt.setInt(1,userId);
            stmt.execute();
            ResultSet rs = stmt.getResultSet();

            while (rs.next()) {
                EmploymentHistory u = getEmploymentHistory(rs);
                result.add(u);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;
    }

}


