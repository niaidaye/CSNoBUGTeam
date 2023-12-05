package com.cskaoyan.demo12.bean;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * 数据库表有 id, name, password, email 字段
 * 完成对应
 *
 * @author Common-zhou
 * @since 2023-12-05 18:29
 */
@Data
@Builder
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
public class Account {
    private Integer accountId;
    private String accountName;
    private String accountPassword;
    private String accountEmail;

}
