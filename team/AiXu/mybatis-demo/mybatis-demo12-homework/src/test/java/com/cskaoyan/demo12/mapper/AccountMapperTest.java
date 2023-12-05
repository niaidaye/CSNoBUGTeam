package com.cskaoyan.demo12.mapper;

import com.cskaoyan.demo12.bean.Account;
import com.cskaoyan.demo12.utils.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AccountMapperTest {
    SqlSession sqlSession;
    AccountMapper accountMapper;

    @BeforeEach
    public void setUp() {
        // 1. 获取sqlSession
        sqlSession = MyBatisUtil.getSqlSession(true);

        // 2. 获取mapper
        accountMapper = sqlSession.getMapper(AccountMapper.class);
    }

    @AfterEach
    public void tearDown() {
        sqlSession.close();
    }


    @Test
    public void queryAccountById() {
        Account expectedAccount = new Account()
                .setAccountId(1)
                .setAccountName("张三")
                .setAccountPassword("password123")
                .setAccountEmail("zhangsan@example.com");

        Account account = accountMapper.queryAccountById(1);
        assertEquals(expectedAccount, account);
    }

    @Test
    public void queryAccountNameById() {
    }

    @Test
    public void queryAllAccountName() {
    }

    @Test
    public void queryAccountBy() {
    }
}