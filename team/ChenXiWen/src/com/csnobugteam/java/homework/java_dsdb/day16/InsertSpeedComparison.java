package com.csnobugteam.java.homework.java_dsdb.day16;

import com.csnobugteam.java.homework.java_dsdb.day16.utils.JDBCUtil;
import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 1. 采用三种不同的方式插入10000条数据，比较速度差别
 * 2. 采用PrepareStatement插入1000w条数据，然后去根据主键查询和根据普通字段查询一条数据，
 *    比较查询速度差别（电脑性能不够的同学可以适当少插入一些数据，以免插入的时间太长）
 * @auther cxw
 * @since 2023/11/30
 */
public class InsertSpeedComparison {

    // 普通循环插入
    @Test
    public void normalInsertion() throws SQLException {
        Connection connection = JDBCUtil.getConnection();
        Statement statement = connection.createStatement();
        long before = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            statement.executeUpdate("insert into t values (" + i + ")");
        }
        long after = System.currentTimeMillis();
        System.out.println("花费时间为：" + (after - before));
        JDBCUtil.release(connection, statement, null);
    }

    // 批处理之Statement
    @Test
    public void statementInsertion() throws SQLException {
        Connection connection = JDBCUtil.getConnection();
        Statement statement = connection.createStatement();
        long before = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            statement.addBatch("insert into t values (" + i + ")");
        }
        statement.executeBatch();
        long after = System.currentTimeMillis();
        System.out.println("花费时间为" + (after - before));
        JDBCUtil.release(connection, statement, null);
    }

    // 批处理之PrepareStatement
    @Test
    public void prepareStatementInsertion() throws SQLException {
        Connection connection = JDBCUtil.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("insert into t values (?)");
        long before = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            preparedStatement.setInt(1, i);
            preparedStatement.addBatch();
        }
        preparedStatement.executeBatch();
        long after = System.currentTimeMillis();
        System.out.println("花费时间为" + (after - before));
        JDBCUtil.release(connection, preparedStatement, null);
    }

    // 比较主键和普通字段查询速度
    @Test
    public void querySpeedComparison() throws SQLException {
        Connection connection = JDBCUtil.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("insert into test(val) values (?)");
        for (int i = 0; i < 10000000; i++) {
            preparedStatement.setInt(1, i);
            preparedStatement.addBatch();
        }
        preparedStatement.executeBatch();
        // 主键查询
        long before1 = System.currentTimeMillis();
        PreparedStatement preparedStatement1 = connection.prepareStatement("select * from test where id = ?");
        preparedStatement1.setInt(1, 900000);
        preparedStatement1.executeQuery();
        long after1 = System.currentTimeMillis();
        System.out.println("主键查询时间为" + (after1 - before1));
        // 普通字段查询
        long before2 = System.currentTimeMillis();
        PreparedStatement preparedStatement2 = connection.prepareStatement("select * from test where val = ?");
        preparedStatement2.setInt(1, 900000);
        preparedStatement2.executeQuery();
        long after2 = System.currentTimeMillis();
        System.out.println("普通字段查询时间为：" + (after2 - before2));
        JDBCUtil.release(connection, preparedStatement, null);
        JDBCUtil.release(null, preparedStatement1, null);
        JDBCUtil.release(null, preparedStatement2, null);
    }
}
