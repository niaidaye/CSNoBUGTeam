package DayList.set;

import java.util.HashSet;
import java.util.Set;

/**
 * @Projectname: CSNoBUGTeam
 * @Filename:
 * @Author: an
 * @Data:2023/11/12 10:09 PM
 * @Description: TODO
 */

/*假设你要开发一个简单的社交网络系统，需要存储用户的兴趣爱好。使用 `HashSet` 存储每个用户的兴趣爱好，然后实现一些操作：

1. 添加用户的兴趣爱好。
2. 移除用户的特定兴趣爱好。
3. 判断某个用户是否具有某个特定的兴趣爱好。
4. 打印当前所有用户的兴趣爱好。*/
import java.util.HashSet;
import java.util.Set;

public class SocialNetwork {
    public static void main(String[] args) {
        // 创建HashSet用于存储用户兴趣爱好
        Set<String> userInterests = new HashSet<>();

        // 添加用户兴趣爱好
        addUserInterest(userInterests, "UserA", "Reading", "Traveling");
        addUserInterest(userInterests, "UserB", "Cooking", "Music", "Hiking");
        addUserInterest(userInterests, "UserC", "Painting", "Reading", "Coding");

        // 打印当前所有用户的兴趣爱好
        printUserInterests(userInterests);

        // 移除用户的特定兴趣爱好
        removeUserInterest(userInterests, "UserA", "Traveling");

        // 打印当前所有用户的兴趣爱好
        printUserInterests(userInterests);

        // 判断某个用户是否具有某个特定的兴趣爱好
        System.out.println("UserA has 'Photography': " + hasUserInterest(userInterests, "UserA", "Photography"));
    }

    // 添加用户兴趣爱好的方法
    private static void addUserInterest(Set<String> userInterests, String user, String ...interests) {
        // String ...本质是可变长数组[] for增强for循环本质就是迭代器实现iterable迭代接口的才能使用，因此Stirng类型并没有迭代功能，所以用String ...
        for (String interest : interests) {
            String key = user + ":" + interest;
            if (!userInterests.contains(key)) {
                userInterests.add(key);
            }
        }
    }

    // 移除用户特定兴趣爱好的方法
    private static void removeUserInterest(Set<String> userInterests, String user, String interest) {
        userInterests.remove(user + ":" + interest);
    }

    // 打印当前所有用户兴趣爱好的方法
    private static void printUserInterests(Set<String> userInterests) {
        System.out.println("User Interests:");
        for (String userInterest : userInterests) {
            System.out.println(userInterest);
        }
        System.out.println();
    }

    // 判断某个用户是否具有某个特定兴趣爱好的方法
    private static boolean hasUserInterest(Set<String> userInterests, String user, String interest) {
        return userInterests.contains(user + ":" + interest);
    }
}
