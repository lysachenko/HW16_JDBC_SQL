package com.lysachenko.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCUtil {
    public static String H2_URL = "jdbc:h2:~/students_db";
    public static String H2_USERNAME = "sa";
    public static String H2_PASSWORD = "";

    public static String MY_SQL_URL = "jdbc:mysql://localhost/students_db?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    public static String MY_SQL_USERNAME = "root";
    public static String MY_SQL_PASSWORD = "root";

    public static Connection getConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(H2_URL, H2_USERNAME, H2_PASSWORD);
            //connection = DriverManager.getConnection(MY_SQL_URL, MY_SQL_USERNAME, MY_SQL_PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
}
