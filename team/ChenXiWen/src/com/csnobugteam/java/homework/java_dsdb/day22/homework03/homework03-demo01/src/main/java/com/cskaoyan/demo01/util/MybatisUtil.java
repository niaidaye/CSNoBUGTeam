package com.cskaoyan.demo01.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * 工具类，可获取SqlSession实例对象
 * @auther cxw
 * @since 2023/12/4
 */
public class MybatisUtil {

    private static SqlSessionFactory sqlSessionFactory;

    static {
        InputStream inputStream = null;
        try {
            inputStream = Resources.getResourceAsStream("mybatis-config.xml");
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static SqlSession getSqlSession() throws IOException {
        return getSqlSession(false);
    }

    public static SqlSession getSqlSession(boolean autoCommit) throws IOException {
        return sqlSessionFactory.openSession(autoCommit);
    }
}
