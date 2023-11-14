package src.homework;

/*
 * @Description:
 * @Author: LN
 *  @Date : 2023/11/11
 */

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

/*
2, 如果List中存储了多个User对象, 去除重复元素(多个重复元素仅保留一个)(假设使用Collection和List的   api)
 */
public class homework {
    public static void main(String[] args) {
        // 存储user对象的方法
        List<User> userList = getInitUserList();

        // 创建一个空的数组
        List<User> temp = new LinkedList<>();
        for (User user : userList) {
            boolean flag = true;
            do {
                User copyUser = user;
                for (User user1 : temp) {
                    if (copyUser.equals(user1)) {
                        flag = false;
                    }
                }
                if (flag) {
                    temp.add(user);
                }
            } while (flag);
        }
        System.out.println(temp);

    }

    private static List<User> getInitUserList() {
        // 创建一个user类型的数组
        List<User> userList = new LinkedList<>();
        User user1 = new User("zs", 18);
        User user2 = new User("ls", 20);
        User user3 = new User("zs", 18);
        User user4 = new User("ww", 16);
        User user5 = new User("ls", 24);
        userList.add(user1);
        userList.add(user2);
        userList.add(user3);
        userList.add(user4);
        userList.add(user5);
        System.out.println(userList);
        return userList;
    }

}

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
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (age != user.age) return false;
        return Objects.equals(name, user.name);
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + age;
        return result;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

