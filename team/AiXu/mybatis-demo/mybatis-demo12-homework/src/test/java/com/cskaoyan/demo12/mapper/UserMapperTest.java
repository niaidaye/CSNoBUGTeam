package com.cskaoyan.demo12.mapper;

import com.cskaoyan.demo12.bean.User;
import com.cskaoyan.demo12.utils.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class UserMapperTest {
    SqlSession sqlSession;
    UserMapper userMapper;

    @BeforeEach
    public void before() {
        // 1. 获取sqlSession
        sqlSession = MyBatisUtil.getSqlSession(true);

        // 2. 获取mapper
        userMapper = sqlSession.getMapper(UserMapper.class);
    }

    @AfterEach
    public void after() {
        sqlSession.close();
    }


    @Test
    void insertUser1() {
        int result = userMapper.insertUser1("username1", "password1", 25, new Date(), new Date(), "1234567890");
        assertEquals(1, result);      }

    @Test
    void insertUser2() {
        int result = userMapper.insertUser2("username2", "password2", 30, new Date(), new Date(), "0987654321");
        assertEquals(1, result);
    }

    @Test
    void updateName() {
        int result = userMapper.updateName("newName", 1);
        assertEquals(1, result);
    }

    @Test
    void deleteByPrimaryKey() {
        int result = userMapper.deleteByPrimaryKey(2);
        assertEquals(1, result);
    }

    @Test
    void insertUser3() {
        User user = new User()
                .setUsername("username3")
                .setPassword("password3")
                .setAge(35)
                .setBirthday(new Date())
                .setCreateDate(new Date())
                .setMobile("1234567890");
        int result = userMapper.insertUser3(user);
        assertEquals(1, result);
    }

    @Test
    void insertUser4() {
        User user = new User()
            .setUsername("username4")
            .setPassword("password4")
            .setAge(40)
            .setBirthday(new Date())
            .setCreateDate(new Date())
            .setMobile("0987654321");
        int result = userMapper.insertUser4(user);
        assertEquals(1, result);
    }
}