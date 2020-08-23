package com.lysachenko.util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class JDBCUtil {

    private final static JDBCUtil instance = new JDBCUtil();

    public static String H2_DB_PROPERTIES = "h2config.properties";
    public static String MYSQL_DB_PROPERTIES = "MySQLconfig.properties";

    private JDBCUtil() {
    }

    public static JDBCUtil getInstance() {
        return instance;
    }

    private Properties getProperties(String filename) {
        Properties properties = new Properties();
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream(filename);
        if (inputStream != null) {
            try {
                properties.load(inputStream);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return properties;
    }

    public Connection getConnection() {
        Properties prop = getProperties(H2_DB_PROPERTIES);

        String url = prop.getProperty("db.url");
        String username = prop.getProperty("db.username");
        String password = prop.getProperty("db.password");

        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
}
