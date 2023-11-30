package com.csnobugteam.java.homework.java_dsdb.day16.utils;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @auther cxw
 * @since 2023/11/30
 */
public class ResultSetUtil {

    public static void parseResultSet(ResultSet resultSet) throws SQLException {
        ResultSetMetaData metaData = resultSet.getMetaData();
        int columnCount = metaData.getColumnCount();
        for (int i = 0; i < columnCount; i++) {
            String columnLabel = metaData.getColumnLabel(i);
            System.out.println(columnLabel);
        }
        while (resultSet.next()) {
            List<String> list = new ArrayList<>();
            for (int i = 1; i <= columnCount; i++) {
                String value = resultSet.getString(i);
                list.add(value);
            }
            System.out.println(list.toString());
        }
    }
}
