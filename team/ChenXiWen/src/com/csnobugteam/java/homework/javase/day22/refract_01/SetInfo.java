package com.csnobugteam.java.homework.javase.day22.refract_01;

import java.lang.reflect.Field;

/**
 * 反射API
 * @auther cxw
 * @since 2023/11/9
 */
public class SetInfo {

    /**
     * 写一个方法，使用反射技术来改变某个对象的属性值
     * @param targetObj 要修改成员变量值的目标对象
     * @param fieldName 对象中要修改的成员变量的名字
     * @param newValue 要修改成员变量值的新值
     * @throws Exception
     */
    public static void setAll(Object targetObj, String fieldName, Object newValue) throws Exception {
        // 获取Class对象
        Class c = targetObj.getClass();
        // 获取name对象
        Field name = c.getDeclaredField("name");
        // 设置属性值
        name.set(targetObj, fieldName);
        // 获取age对象
        Field age = c.getDeclaredField("age");
        // 设置属性值
        age.set(targetObj, newValue);
    }
}



