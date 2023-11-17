package com.csnobugteam.java.homework.day24;

import com.csnobugteam.java.utils.UserUtil;

import java.util.*;

/**
 * 2, 如果List中存储了多个User对象, 去除重复元素(多个重复元素仅保留一个)(假设使用Collection和List的api)
 *
 * @author aixu
 * @since 2023/11/11
 */
public class UserList {

    public List<User> testUserList;
    /**
     * 初始化多个user对象
     */
    private void initUserDate() {
        List<User> testUserList = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            String userName = UserUtil.getCharAndNum(5);
            testUserList.add(new User(userName, userName));
            // 添加2组重复数据
            testUserList.add(new User(userName, userName));
            testUserList.add(new User(userName, userName));

        }

        this.testUserList = testUserList;
    }

    public UserList() {
        initUserDate();
    }

    // 去除重复元素(多个重复元素仅保留一个)
    public List<User> removeDuplicateUserKeepOnlyOne(List<User> users) {
        // 保存重复的user
        List<User> newUsers = new ArrayList<>();
        for (User user : users) {
            // 进行重复判断，如果不重复就添加user
            if (!judgeUsersIsDuplicate(user,newUsers)) newUsers.add(user);
        }
        return newUsers;
    }

    // 老师的方法
    public List<User> removeDuplicateUserKeepOnlyOne() {
        // 通过迭代器，进行，重复判断，
        Iterator<User> iterator = testUserList.iterator();
        while (iterator.hasNext()) {
            // 通过迭代器来，存储下个元素
            User next = iterator.next();
            // 查重，如果存在，重复元素，那么向前查找，和向后查找，的元素下标，将会不一样
            if (testUserList.indexOf(next) != testUserList.lastIndexOf(next)) {
                // 调用迭代器里的删除元素
                iterator.remove();
            }
        }
        return testUserList;
    }


    /**
     * 将List中的元素与传过来的元素进行对比，判断是否有重复
     * @param user 进行对比的user
     * @param users 判断结合
     * @return 重复返回true，否则，返回false
     */
    private boolean judgeUsersIsDuplicate(User user, List<User> users) {
        for (User t : users) {
            if (user.equals(t)) return true;
        }
        return false;
    }

}

