package com.cskaoyan.demo01.mapper;

import com.cskaoyan.demo01.bean.Account;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @auther cxw
 * @since 2023/12/6
 */
public interface AccountMapper {

    List<Account> queryAccountByNameAndAddress(@Param("name") String name, @Param("address") String address);

    List<Account> queryAccountByCondition(Account account);

    List<Account> queryAccountByCondition2(Account account);

    List<Account> queryAccountByCondition3(@Param("age") Integer age);

}
