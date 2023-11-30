package com.csnobugteam.java.utils;

import java.sql.*;

import org.junit.Test;

import com.csnobugteam.java.pool.CusDataSource;

/**
 * JDBCUtilsTest
 * 
 * @author aixu
 */
public class JDBCUtilsTest {

    @Test
    public void getConnection() throws SQLException {
        // 从池子里拿连接； 用完之后，归还连接
        Connection connection1 = CusDataSource.getConnection();
        Connection connection2 = CusDataSource.getConnection();
        Connection connection3 = CusDataSource.getConnection();

        long time1 = System.currentTimeMillis();
        batchUseFor(connection1);

        long time2 = System.currentTimeMillis();

        batchUseAddBatch(connection2);
        long time3 = System.currentTimeMillis();

        batchUsePrepareStatement(connection3);
        long time4 = System.currentTimeMillis();

        System.out.println("for耗时:" + (time2 - time1) + "ms");
        System.out.println("statementBatch耗时:" + (time3 - time2) + "ms");
        System.out.println("prepareStatement耗时:" + (time4 - time3) + "ms");

        JDBCUtils.close(connection1);
        JDBCUtils.close(connection2);
        JDBCUtils.close(connection3);

    }

    // 1. 通过for循环，statement循环插入
    public void batchUseFor(Connection connection) throws SQLException {
        Statement statement = connection.createStatement();

        for (int i = 1; i <= 1000; i++) {
            // insert into user(id, name) values(1, 'for');
            String sql = "insert into dept(id, dname) values(" + i + ", 'for" + "')";

            statement.executeUpdate(sql);
        }

        statement.close();
    }

    // 2.通过statement的addBatch()方法，批量插入
    public static void batchUseAddBatch(Connection connection) throws SQLException {
        Statement statement = connection.createStatement();

        for (int i = 1001; i <= 2000; i++) {
            // insert into user(id, name) values(1, 'for');
            // String sql1 = "insert into user(id, name) values (" + i + ", 'for')";

            String sql = "insert into dept(id, dname) values(" + i + ", 'sta" + "')";
            // 就是将要执行的SQL，先放到一个集合里面去，然后一次性执行。
            statement.addBatch(sql);
        }

        statement.executeBatch();
        statement.close();
    }

    public static void batchUsePrepareStatement(Connection connection) throws SQLException {
        // 3.通过PrepareStatement的addBatch()方法，批量插入
        PreparedStatement preparedStatement = connection.prepareStatement("insert into dept(id, dname) values(?, ?)");

        // [{2001, pre}, {2002, pre}]

        for (int i = 2001; i <= 3000; i++) {
            preparedStatement.setInt(1, i);
            preparedStatement.setString(2, "pre");

            preparedStatement.addBatch();
        }

        preparedStatement.executeBatch();
        preparedStatement.close();

    }
}