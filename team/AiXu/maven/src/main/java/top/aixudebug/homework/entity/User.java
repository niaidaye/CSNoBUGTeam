package top.aixudebug.homework.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * 用户实体类
 * @author aixu
 * @since 2023/12/4
 */
@Data
//@AllArgsConstructor
public class User {
    private Integer id;
    private String username;
    private String password;

    public User(String username, String password) {
        setUsername(username);
        setPassword(password);
    }
}
