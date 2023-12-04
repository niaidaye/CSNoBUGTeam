package top.aixudebug.stumaven.mapper;

import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import top.aixudebug.homework.entity.User;
import top.aixudebug.homework.mapper.UserMapper;
import top.aixudebug.homework.utils.MybatisGetSessionUtil;

class UserMapperTest {

    @Test
    void signInByUser() {
        User user = new User("wangjie", "wangjie");
        SqlSession sqlSession = MybatisGetSessionUtil.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        int i = userMapper.signInByUser(user);
        Assertions.assertEquals(1,i);
        sqlSession.commit();
    }

    @Test
    void loginByUser() {
        SqlSession sqlSession = MybatisGetSessionUtil.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = userMapper.loginByUser("user","user");
        Assertions.assertEquals("user",user.getUsername());
    }

    @Test
    void updateById() {
        SqlSession sqlSession = MybatisGetSessionUtil.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        int i = userMapper.updateById(4, "aaaa", "qqqq");
        Assertions.assertEquals(1,i);
        sqlSession.commit();
    }

    @Test
    void deleteUserById() {
        SqlSession sqlSession = MybatisGetSessionUtil.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        int i = userMapper.deleteUserById(4);
        Assertions.assertEquals(1, i);
        sqlSession.commit();
    }
}