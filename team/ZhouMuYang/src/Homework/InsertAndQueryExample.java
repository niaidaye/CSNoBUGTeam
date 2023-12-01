package Homework;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertAndQueryExample {

    public static void main(String[] args) {
        Connection connection = null;
        try {
            // 建立连接
            connection = DriverManager.getConnection("dbc:mysql://localhost:3306/java55th?useUnicode=true&characterEncoding=utf8&useSSL=false&rewriteBatchedStatements=true", "root", "123456");

            batchInsertData(connection);

            queryByPrimaryKey(connection, 1);

            queryByField(connection, "some_value");

            getBatch(connection);

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static void getBatch(Connection connection) throws SQLException {
        Statement statement = connection.createStatement();

        for (int i = 0; i < 199; i++) {
            String sql = "insert into table values (" + i + ",dsf,null,null)";
            System.out.println(sql);
        }

    }

    private static void batchInsertData(Connection connection) throws SQLException {
        String insertSQL = "INSERT INTO test (column1, column2) VALUES (?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(insertSQL)) {
            for (int i = 0; i < 10_000_000; i++) {
                // 设置参数的值
                preparedStatement.setInt(1, i);
                preparedStatement.setString(2, "some_value");

                // 将数据加到batch中
                preparedStatement.addBatch();

                if (i % 1000 == 0) {
                    preparedStatement.executeBatch();
                }
            }
            preparedStatement.executeBatch();
        }
    }

    private static void queryByPrimaryKey(Connection connection, int primaryKeyValue) throws SQLException {
        String querySQL = "SELECT * FROM test WHERE primary_key_column = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(querySQL)) {
            preparedStatement.setInt(1, primaryKeyValue);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int primaryKey = resultSet.getInt("primary_key_column");
                String column2 = resultSet.getString("column2");

                System.out.println("Primary Key: " + primaryKey + ", Column2: " + column2);
            }
        }
    }

    private static void queryByField(Connection connection, String fieldValue) throws SQLException {
        String querySQL = "SELECT * FROM test WHERE column2 = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(querySQL)) {
            preparedStatement.setString(1, fieldValue);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int primaryKey = resultSet.getInt("primary_key_column");
                String column2 = resultSet.getString("column2");

                System.out.println("Primary Key: " + primaryKey + ", Column2: " + column2);
            }
        }
    }
}
