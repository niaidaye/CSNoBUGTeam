package com.csnobugteam.java.utils;

import java.util.Random;

/**
 * User工具类，
 * 方法1:生成随机length长度数字和字母组合
 */
public class UserUtil {
    /**
     * 方法：生成随机length长度数字和字母组合
     * 用于生成随机用户数据
     *
     * @param length 随机长度
     * @return length
     */
    public static String getCharAndNum(int length) {
        StringBuilder randomBuilder = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            // 选择输出字母还是数字
            String charOrNum = random.nextInt(2) % 2 == 0 ? "char" : "num";
            if ("char".equalsIgnoreCase(charOrNum)) {
                // 字符串
                // 取得大写字母还是小写字母
                int choice = random.nextInt(2) % 2 == 0 ? 65 : 97;
                randomBuilder.append((char) (choice + random.nextInt(26)));
            } else {
                // 数字
                randomBuilder.append(random.nextInt(10));
            }
        }
        return randomBuilder.toString();
    }
}
