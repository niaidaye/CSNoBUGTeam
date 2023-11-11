package _01work.com.csnobug.dsdb.day03.work02;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

/**
 * Descripsion:
 *
 * @Author dengp
 * @create 2023/11/11 15:03
 * @Version 1.0
 */
/*
2, 如果List中存储了多个User对象, 去除重复元素(多个重复元素仅保留一个)(假设使用Collection和List的api)
 */
public class Demo {
    public static void main(String[] args) {
        // init List
        List<User> initUserList = getInitUserList();

        //使用List的api去除重复元素
        useListApiDeleteUserForTheSameElement(initUserList);

    }

    private static void useListApiDeleteUserForTheSameElement(List<User> initUserList) {
        List<User> temp = new ArrayList<>();

        for (User user : initUserList) {
            // 标记前面list是否有重复元素
            boolean flag = true;
            User newUser = user;
            // 如果有重复元素，那么flag = false
            for (User user1 : temp) {
                // User类中重写equals，这里用重写后的equals
                if (newUser.equals(user1)) {
                    flag = false;
                }
            }
            // 没有重复项，将元素插入新list
            if (flag) {
                temp.add(user);
            }
        }

        initUserList = temp;
        System.out.println("--------------delete the same element:--------------");
        System.out.println(initUserList);
    }

    // 使用HashSet，在一开始就过滤重复数据
    // private static void useListApiDeleteUserForSameElement(List<User> initUserList) {
    //     HashSet<User> userHashSet = new HashSet<>(initUserList);
    //     List<User> userList = new ArrayList<>(userHashSet);
    //     // 使用List的API删除重复元素
    //     initUserList.clear();
    //     initUserList.addAll(userList);
    // }

    public static List<User> getInitUserList() {
        List<User> initUserList = new LinkedList<>();
        initUserList.add(new User("zs", 19));
        initUserList.add(new User("ls", 18));
        initUserList.add(new User("wu", 20));
        initUserList.add(new User("zs", 19));
        initUserList.add(new User("zl", 22));
        initUserList.add(new User("ls", 18));

        System.out.println("--------------print the init List:--------------");
        System.out.println(initUserList);

        return initUserList;
    }
}

class User {
    String name;
    int age;

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
        return age == user.age &&
                Objects.equals(name, user.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }
}
