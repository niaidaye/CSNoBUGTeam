package com.csnobugteam.java.homework.day27;

import java.util.HashMap;
import java.util.Map;

/**
 * "aababcabcdabcde",获取字符串中每一个字母出现的次数要求结果:a(5)b(4)c(3)d(2)e(1)
 *
 * @author aixu
 * @since 2023/11/15
 */
public class HomeWork01 {
    /**
     * 获取字符串中的每个字母的个数
     *
     * @param string 目标字符串
     * @return K-V
     */
    public Map<Character, Integer> getNumsOfAppears(String string) {
        Map<Character, Integer> res = new HashMap<>();
        char[] charArray = string.toCharArray();
        if (charArray.length == 0) return res;
        // 进行双指针遍历，
        int front = 0, after = charArray.length - 1;
        while (front < after) {
            // 前指针加
            putResMap(res, charArray[front]);
            // 后指针加
            putResMap(res, charArray[after]);
            front++;
            after--;
        }

        // 处理中间点，没有添加问题
        if (front == after) {
            putResMap(res, charArray[front]);
        }

        return res;
    }

    /**
     * 进行数量计算添加
     *
     * @param res 待返回map
     * @param character 待检测字符
     */
    private void putResMap(Map<Character, Integer> res, Character character) {
        int count = res.getOrDefault(character, 0);
        res.put(character, ++count);
    }
}
