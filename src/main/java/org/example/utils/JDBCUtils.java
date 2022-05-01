package org.example.utils;

import java.sql.*;

public class JDBCUtils {
    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public static Connection getConnection(String url, String username, String pwd)
            throws SQLException {
        return DriverManager.getConnection(url, username, pwd);
    }
}
