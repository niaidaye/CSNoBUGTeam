package com.csnobugteam.java.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

/**
 * JDBC连接工具类
 * 
 * @author aixu
 */
public class JDBCUtils {

    static String url;
    static String username;
    static String password;
    static String driver;

    static {

        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream("jdbc.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }


        url = properties.getProperty("url");
        username = properties.getProperty("username");
        password = properties.getProperty("password");
        driver = properties.getProperty("driverClassName");
    }


    // 获取连接
    public static Connection getConnection(){

        Connection connection = null;
        try {
            Class.forName(driver);
            connection = DriverManager.getConnection(url, username, password);
        }catch (Exception ex) {
            ex.printStackTrace();
        }

        return connection;
    }



    // 关闭资源
    public static void  close(Connection connection, PreparedStatement statement, ResultSet resultSet){

        try {

            if (resultSet != null) resultSet.close();
            if (statement!= null) statement.close();
            if (connection != null) connection.close();

        }catch (Exception ex) {
            ex.printStackTrace();
        }


    }
    public static void  close(Connection connection){

        try {
            if (connection != null) connection.close();

        }catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}