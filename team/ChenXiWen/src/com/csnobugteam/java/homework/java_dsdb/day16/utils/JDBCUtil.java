package com.csnobugteam.java.homework.java_dsdb.day16.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

/**
 * @auther cxw
 * @since 2023/11/30
 */
public class JDBCUtil {

    private  static String url;
    private static String username;
    private static String password;

    static {
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream("jdbc.properties"));
            url = properties.getProperty("url");
            username = properties.getProperty("username");
            password = properties.getProperty("password");
            String driverClassName = properties.getProperty("driverClassName");
            Class.forName(driverClassName);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static Connection getConnection() throws SQLException{
        return DriverManager.getConnection(url, username, password);
    }

    public static void release(Connection connection, Statement statement, ResultSet resultSet) throws SQLException {
        if (resultSet != null) {
            resultSet.close();
        }
        if (statement != null) {
            statement.close();
        }
        if (connection != null) {
            connection.close();
        }
    }
}
