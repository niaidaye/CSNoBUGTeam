package com.csnobugteam.java.homework.java_dsdb.day16.cusdatasource;

import com.csnobugteam.java.homework.java_dsdb.day16.utils.JDBCUtil;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * 手写连接池，并增加自动扩容功能
 * @auther cxw
 * @since 2023/11/30
 */
public class CusDataSource {

    // 容量上限
    static final int CELL = 100;
    // 连接池中创建的连接数量
    static int count;

    private static List<Connection> connections = new ArrayList<>();

    static {
        for (int i = 0; i < 10; i++) {
            try {
                connections.add(JDBCUtil.getConnection());
                count++;
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static Connection getConnection() throws SQLException {
        if (connections.isEmpty()) {
            // 如果超出上限，则不再创建新的连接
            if (count >= CELL) {
                throw new RuntimeException("连接爆满，请等待！");
            }
            connections.add(JDBCUtil.getConnection());
            count++;
        }
        // 从集合中取一个
        return connections.remove(connections.size() - 1);
    }

    public static void returnConnection(Connection connection) {
        connections.add(connection);
    }
}
