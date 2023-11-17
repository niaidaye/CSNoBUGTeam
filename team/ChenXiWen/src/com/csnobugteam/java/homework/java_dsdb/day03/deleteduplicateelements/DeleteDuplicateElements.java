package com.csnobugteam.java.homework.java_dsdb.day03.deleteduplicateelements;

import org.junit.Test;

import java.util.*;

/**
 * 如果List中存储了多个User对象, 去除重复元素(多个重复元素仅保留一个)(假设使用Collection和List的api)
 * @auther cxw
 * @since 2023/11/11
 */
public class DeleteDuplicateElements {

    @Test
    public void deleteDuplicate() {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        List<User> list = new ArrayList<User>();
        list.add(new User("zs", 18));
        list.add(new User("ls", 19));
        list.add(new User("zs", 18));
        list.add(new User("ww", 20));
        list.add(new User("zs", 18));
        // 定义一个辅助容器
        List<User> userList = new ArrayList<>();
        // 获取list的迭代器
        ListIterator<User> listIterator = list.listIterator();
        // 向后遍历，如果辅助容器中不存在遍历后的元素，则将该元素添加进辅助容器
        while (listIterator.hasNext()) {
            User user = listIterator.next();
            if (!userList.contains(user)) {
                userList.add(user);
            }
        }
        // 将辅助容器赋值给list
        list = userList;
        System.out.println(list);

    }
}

// 注意User类需重写equals方法
class User {
    String name;
    int age;

    public User() {
    }

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return age == user.age && Objects.equals(name, user.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }
}
