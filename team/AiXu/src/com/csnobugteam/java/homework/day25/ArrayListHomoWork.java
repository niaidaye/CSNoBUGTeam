package com.csnobugteam.java.homework.day25;

import java.util.ArrayList;
import java.util.List;

/**
 * 假设有一个字符串"abcqweracb" 在不改变前后顺序的前提下去除重复的字符得到"abcqwer"(结合使用ArrayList)
 *
 * @author aixu
 * @since 2023/11/13
 */
public class ArrayListHomoWork {
    public String overKillString(String string) {
        // 遍历原字符串
        char[] charArray = string.toCharArray();
        //
        List<Character> characterList = new ArrayList<>();

        for (char c : charArray) {
            if (!characterList.contains(c)) {
                characterList.add(c);
            }
        }
        return characterList.toString();
    }
}
