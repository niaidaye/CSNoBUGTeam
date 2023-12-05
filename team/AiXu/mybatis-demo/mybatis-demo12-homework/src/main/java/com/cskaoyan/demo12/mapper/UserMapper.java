package com.cskaoyan.demo12.mapper;

import com.cskaoyan.demo12.bean.User;
import org.apache.ibatis.annotations.Param;

import java.util.Date;

/**
 * Mapper → MyBatis的Dao对象的名称
 * UserDao → UserMapper
 */
public interface UserMapper {
    int insertUser1(String username, String password, Integer age, Date birthday, Date createDate, String mobile);

    int insertUser2(@Param("username") String username, @Param("password") String password,
                    @Param("age") Integer age, @Param("birthday") Date birthday, @Param("createDate") Date createDate,
                    @Param("mobile") String mobile);

    int updateName(@Param("name") String name, @Param("id") Integer id);

    int deleteByPrimaryKey(@Param("id") Integer id);
    int insertUser3(User user);
    int insertUser4(@Param("user") User user);
}
