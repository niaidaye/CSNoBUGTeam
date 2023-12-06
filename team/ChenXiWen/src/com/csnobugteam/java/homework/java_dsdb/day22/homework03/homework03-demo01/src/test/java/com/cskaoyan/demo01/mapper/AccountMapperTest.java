package com.cskaoyan.demo01.mapper;

import com.cskaoyan.demo01.bean.Account;
import com.cskaoyan.demo01.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @auther cxw
 * @since 2023/12/6
 */
public class AccountMapperTest {

    SqlSession sqlSession;
    AccountMapper accountMapper;

    @Before
    public void setUp() throws Exception {
        sqlSession = MybatisUtil.getSqlSession();
        accountMapper = sqlSession.getMapper(AccountMapper.class);
    }

    @After
    public void tearDown() throws Exception {
        sqlSession.close();
    }

    @Test
    public void queryAccountByNameAndAddress() {
        List<Account> accountList = accountMapper.queryAccountByNameAndAddress("张三", "北京");
        for (Account account : accountList) {
            System.out.println(account);
        }
    }

    @Test
    public void queryAccountByCondition() {
        Account account = Account.builder().name("李四").email("4453@163.com").build();
        List<Account> accountList = accountMapper.queryAccountByCondition(account);
        for (Account account1 : accountList) {
            System.out.println(account1);
        }
    }

    @Test
    public void queryAccountByCondition2() {
        Account account = new Account();
        //account.setId(3);
        //account.setName("王五");
        account.setPhone("33444");
        List<Account> accountList = accountMapper.queryAccountByCondition2(account);
        for (Account account1 : accountList) {
            System.out.println(account1);
        }
    }

    @Test
    public void queryAccountByCondition3() {
        List<Account> accountList = accountMapper.queryAccountByCondition3(-2);
        for (Account account : accountList) {
            System.out.println(account);
        }
    }
}