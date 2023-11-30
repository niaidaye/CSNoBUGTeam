package com.csnobugteam.java.pool;

import java.util.ArrayList;
import java.util.List;

import com.csnobugteam.java.utils.JDBCUtils;

import java.sql.Connection;

/**
 * CusDataSource-——数据库连接池
 *  1.对外提供连接
 *  2.对外提供归还连接的功能
 */
public class CusDataSource {
    // 连接池pools
    private static List<Connection> pools = new ArrayList<>();

    static {
        for (int i = 0; i < 10; i++) {
                
            pools.add(JDBCUtils.getConnection());
            
        }
    }

    public static Connection getConnection() {
        if (pools.size() == 0) {
            // 说明什么？ 池子空了，这时候没连接了
            return null;
        }
        // 从集合里取一个；  取的最后一个
        return pools.remove(pools.size() - 1);
    }
    public static void returnConnection(Connection connection) {
        pools.add(connection);
    }
    
}