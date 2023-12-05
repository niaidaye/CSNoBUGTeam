package com.cskaoyan.demo12.mapper;

import com.cskaoyan.demo12.bean.Account;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author Common-zhou
 * @since 2023-12-05 18:27
 */
public interface AccountMapper {

    Account queryAccountById(Integer id);

    String queryAccountNameById(Integer id);

    List<String> queryAllAccountName();

    List<Account> queryAccountBy();

}
