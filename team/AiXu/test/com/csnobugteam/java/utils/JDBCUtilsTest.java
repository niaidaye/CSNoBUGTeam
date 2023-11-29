package com.csnobugteam.java.utils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Test;


/**
 * JDBCUtilsTest
 * @author aixu
 */
public class JDBCUtilsTest {


    @Test
    public void getConnection() throws SQLException {
        // 获取数据库连接
        Connection connection = JDBCUtils.getConnection();

        // 执行查询语句
        String sql = "select s.name as sname, t.name as tname from t_stu as s\n" + //
                "inner join t_staff t\n" + //
                "ON s.tutorid = t.id;";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);

        // 获取查询结果中的数据
        while (resultSet.next()){
            // String sname = resultSet.getString("sname");
            // String tname = resultSet.getString("tname");

            String sname = resultSet.getString(1);
            String tname = resultSet.getString(2);

            System.out.println(sname + " : " + tname);
            // assertEquals(7, count); // 断言查询结果是否正确
        }

        // 关闭数据库连接
        JDBCUtils.closeConnection(connection);
    }
}