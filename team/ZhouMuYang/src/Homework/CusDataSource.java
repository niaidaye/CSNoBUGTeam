package Homework;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CusDataSource {

    private static List<Connection> connections = new ArrayList<>();
    private static final int MAX_POOL_SIZE = 20; // 最大连接数

    static {
        initializeConnections();
    }

    private static void initializeConnections() {
        for (int i = 0; i < 10; i++) {
            try {
                connections.add(JdbcUtil.getConnection());
            } catch (SQLException | ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
    }



    public static Connection getConnection() {
        if (connections.size() == 0) {
            // 连接池为空，考虑扩容
            if (connections.size() < MAX_POOL_SIZE) {
                // 动态创建新的连接
                try {
                    Connection newConnection = JdbcUtil.getConnection();
                    connections.add(newConnection);
                    return newConnection;
                } catch (SQLException | ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }
            } else {
                // 连接池已满，无法提供连接
                return null;
            }
        }
        // 从集合里取一个
        return connections.remove(0);
    }

    public static void returnConnection(Connection connection) {
        connections.add(connection);
    }
}
