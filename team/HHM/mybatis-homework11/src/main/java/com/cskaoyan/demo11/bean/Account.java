package com.cskaoyan.demo11.bean;

import lombok.Data;

/**
 * 数据库表有 id, name, password, email 字段
 * 完成对应
 *
 * @author Common-zhou
 * @since 2023-12-05 18:29
 */
@Data
public class Account {

    private Integer id;
    private String name;
    private String address;
    private String email;
    private String phone;
    private Integer age;


}
