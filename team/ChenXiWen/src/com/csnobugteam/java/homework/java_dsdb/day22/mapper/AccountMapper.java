package com.csnobugteam.java.homework.java_dsdb.day22.mapper;



import com.csnobugteam.java.homework.java_dsdb.day22.bean.Account;

import java.util.List;

/**
 * @auther cxw
 * @since 2023/12/6
 */
public interface AccountMapper {

    List<Account> queryAccountByNameAndAddress(String name, String address);

    List<Account> queryAccountByCondition(Account account);

    List<Account> queryAccountByCondition2(Account account);

    List<Account> queryAccountByCondition3(Integer age);

}
