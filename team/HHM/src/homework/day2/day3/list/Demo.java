package homework.day2.day3.list;

import java.util.*;

/**
 * @Projectname: dsdc
 * @Filename:
 * @Author: an
 * @Data:2023/11/11 9:11 AM
 * @Description: TODO
 */
//List接口使用
//2, 如果List中存储了多个User对象,
// 去除重复元素(多个重复元素仅保留一个)
// (假设使用Collection和List的api)
public class Demo {
    public static void main(String[] args) {
        //一般用法
        List<User> userList=new ArrayList<>();

        //添加对象到list
        UseDate(userList);
        //foreach 遍历列表
//        for (User user:
//             userList) {
////            System.out.println(user);
//
//            //使用Set集合去重复 set是一个不允许重复的集合
//
//        }
        Set<User> userSet=new HashSet<>(userList);
        //将去重后的结果重新放回List（如果需要List类型的结果）
        List<User>uniqueUserList=new ArrayList<>(userSet);

        for (User user:uniqueUserList
             ) {
            System.out.println(user);
        }
    }

    private static void UseDate(List<User> userList) {
        userList.add(new User("Alice",21,3222));
        userList.add(new User("Alice",21,3222));
        userList.add(new User("Bob",24,222243));
        userList.add(new User("Tim",11,223422));
        userList.add(new User("Tim",11,223422));
        userList.add(new User("Tim",11,223422));

    }


}
//List的API接口
//
class User{
    String name;
    int age;
    int id;

    public User(String name, int age, int id) {
        this.name = name;
        this.age = age;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", age=" + age +
                '}';
    }
    /*在你提供的代码中，重复的元素被添加到了 userList 中。这是因为 User 类没有正确实现 equals 和 hashCode 方法，
    所以 HashSet 在判断元素是否相等时使用默认的 Object 类的实现，它是基于对象的引用地址比较，而不是基于内容比较。*/
    //重写overdide方法

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        User user = (User) obj;
        return age == user.age && id == user.id && Objects.equals(name, user.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, id);
    }
}
