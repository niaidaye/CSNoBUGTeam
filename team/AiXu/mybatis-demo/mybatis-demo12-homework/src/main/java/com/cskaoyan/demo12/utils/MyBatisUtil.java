package com.cskaoyan.demo12.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;

/**
 * Mybatis连接池
 *
 * @author aixu
 * @since 2023/12/5
 */
public class MyBatisUtil {
    private static final String resource = "config/mybatis-config.xml";

    private static final SqlSessionFactory factory;

    private MyBatisUtil() {}
    static  {
        try {
            factory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream(resource));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static SqlSession getSqlSession() {
        return getSqlSession(false);
    }

    public static SqlSession getSqlSession(boolean autoCommit) {
        return factory.openSession(autoCommit);
    }

    // TODO
//    public static void doSqlWork(Consumer<Object> consumer) {
//        consumer.accept(getSession().getMapper(Object.class));
//    }
}
