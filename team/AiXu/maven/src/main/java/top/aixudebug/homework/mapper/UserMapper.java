package top.aixudebug.homework.mapper;

import org.apache.ibatis.annotations.Param;
import top.aixudebug.homework.entity.User;


/**
 * 用户mapper
 *
 * @author aixu
 * @since 2023/12/4
 */

public interface UserMapper {
    // 1. 注册接口
    int signInByUser(User user);

    //2. 登录接口
    User loginByUser(@Param("username") String username, @Param("password") String password);

    //3. 修改用户信息
    int updateById(@Param("id")int id, @Param("username") String username, @Param("password") String password);

    //4. 销户
    int deleteUserById(@Param("id") int id);

    //5. 修改登录状态
    int updateStateByUsername(@Param("username") String username,@Param("stare") String stare);
}
