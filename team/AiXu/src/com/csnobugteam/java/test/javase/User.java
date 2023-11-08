package com.csnobugteam.java.test.javase;

import java.io.Serializable;

/**
 * 用户对象
 *
 * @author aixu
 * @since 2023/11/8
 */
public class User implements Serializable {

    private String username;
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
