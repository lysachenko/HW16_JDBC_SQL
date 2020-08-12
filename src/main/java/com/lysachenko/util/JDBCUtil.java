package com.lysachenko.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCUtil {
    public static String H2_URL = "jdbc:h2:~/students_db";
    public static String H2_USERNAME = "sa";
    public static String H2_PASSWORD = "";

    public static Connection getConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(H2_URL, H2_USERNAME, H2_PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
}
