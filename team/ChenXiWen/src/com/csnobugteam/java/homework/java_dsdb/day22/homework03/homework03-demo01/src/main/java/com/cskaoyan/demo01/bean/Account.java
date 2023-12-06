package com.cskaoyan.demo01.bean;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @auther cxw
 * @since 2023/12/6
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Accessors(chain = true)
public class Account {
    private Integer id;
    private String name;
    private String address;
    private String email;
    private String phone;
    private Integer age;
}
