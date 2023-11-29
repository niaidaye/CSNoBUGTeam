package com.csnobugteam.java.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * JDBC连接工具类
 * @author aixu
 */
public class JDBCUtils {

    private static final String DB_URL = "jdbc:mysql://mysql.aixudebug.top:3306/db_wangdao_homework?characterEncoding=utf8&useSSL=false";
    private static final String USER = "aixu";
    private static final String PASSWORD = "XXXXXX";

    public static Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
        return connection;
    }

    public static void closeConnection(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void executeQuery(Connection connection, String query) throws SQLException {
        Statement statement = connection.createStatement();
        statement.execute(query);
    }
}