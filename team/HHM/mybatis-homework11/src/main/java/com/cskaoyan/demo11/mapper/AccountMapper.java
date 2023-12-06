package com.cskaoyan.demo11.mapper;

import com.cskaoyan.demo11.bean.Account;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author Common-zhou
 * @since 2023-12-05 18:27
 */
//有一个账户表：里面有 id name address email phone age
//
//        1.练习，根据name或者address来查询。如果name传了则拼接。 如果address传了则拼接。
//
//        且两者是and的关系



public interface AccountMapper {
//1.练习，根据name或者address来查询。如果name传了则拼接。 如果address传了则拼接。
    List<Account> queryAccountByNameAndAddress(@Param("name") String name, @Param("address") String address);

    // 如果传了 名字就根据名字查； 如果传了address，就拼接address；如果传了email就根据email查
    List<Account> queryAccountByCondition(@Param("account") Account account);

    // 如果传了id，就根据id查； 否则，如果名字不为空，根据name来查；  否则，根据手机号查
    List<Account> queryAccountByCondition1(@Param("account") Account account);

    // 如果年龄输入小于0.则不拼接；如果在18岁以下，就拼接 age=18; 否则，就拼接年龄>18
    List<Account> queryAccountByCondition2(Integer age);

}
