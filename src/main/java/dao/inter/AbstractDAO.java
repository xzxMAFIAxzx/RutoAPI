package dao.inter;

import entity.UserSkill;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.List;

public abstract class AbstractDAO {
    public Connection connect() throws Exception {
        String url = "jdbc:mysql://localhost:1320/ruto";
        String username = "root";
        String password = "12345";
        Connection c = DriverManager.getConnection(url, username, password);
        return c;
    }

}
