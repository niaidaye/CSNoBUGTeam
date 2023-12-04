package top.aixudebug.homework.utils;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * mybatis连接工具类
 *
 * @author aixu
 * @since 2023/12/4
 */
public class MybatisGetSessionUtil {
    private static final String RESOURCE = "mybatis-config.xml";
    private static final SqlSessionFactory sqlSessionFactory;

    static {
        try (InputStream inputStream = MybatisGetSessionUtil.class
                .getClassLoader().getResourceAsStream(RESOURCE)) {
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        } catch (IOException e) {
            throw new RuntimeException("SqlSessionFactory 初始化错误", e);
        }
    }

    public static SqlSession getSqlSession() {
        return sqlSessionFactory.openSession();
    }
}
