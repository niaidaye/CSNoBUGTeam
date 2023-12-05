package com.cskaoyan.demo12.bean;

import lombok.Builder;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author Common-zhou
 * @since 2023-12-05 18:24
 */
@Data
@Builder
@Accessors(chain = true)
public class Student {
    private Integer id;
    private String name;
    private Integer age;
    private String address;
    private int height;
}
