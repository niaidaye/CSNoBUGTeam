package com.csnobugteam.java.pool;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class ConnectionPool {

    private static ConnectionPool instance;
    private List<Connection> connections = new ArrayList<>();
    private String url;
    private String username;
    private String password;
    private int initialPoolSize = 10;
    private int maxPoolSize = 100;

    private ConnectionPool() {
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream("jdbc.properties"));
            url = properties.getProperty("url");
            username = properties.getProperty("username");
            password = properties.getProperty("password");
            initialPoolSize = Integer.parseInt(properties.getProperty("initialPoolSize"));
            maxPoolSize = Integer.parseInt(properties.getProperty("maxPoolSize"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < initialPoolSize; i++) {
            connections.add(createConnection());
        }
    }

    public static synchronized ConnectionPool getInstance() {
        if (instance == null) {
            instance = new ConnectionPool();
        }
        return instance;
    }

    public synchronized Connection getConnection() {
        if (connections.isEmpty()) {
            if (connections.size() < maxPoolSize) {
                connections.add(createConnection());
            } else {
                throw new RuntimeException("连接池满了");
            }
        }
        return connections.remove(connections.size() - 1);
    }

    public synchronized void releaseConnection(Connection connection) {
        if (connection != null) {
            connections.add(connection);
        }
    }

    private Connection createConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // 需要根据实际情况修改驱动类名
            connection = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
}
