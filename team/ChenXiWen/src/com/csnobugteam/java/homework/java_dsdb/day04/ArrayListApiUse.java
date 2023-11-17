package com.csnobugteam.java.homework.java_dsdb.day04;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

/**
 * 假设有一个字符串"abcqweracb" 在不改变前后顺序的前提下去除重复的字符得到"abcqwer"(结合使用ArrayList)
 * @auther cxw
 * @since 2023/11/13
 */
public class ArrayListApiUse {
    @Test
    public void removeDuplicatesChar() {
        String str = "abcqweracb";
        String[] strings = str.split("");
        List<String> list = new ArrayList<>();
        for (String string : strings) {
            list.add(string);
        }
        // 创建一个字符串，如果字符没有重复，则拼接
        String strRecord = "";
        // 创建一个辅助集合
        List<String> tempList = new ArrayList<>();
        // 获得迭代器
        ListIterator<String> iterator = list.listIterator();
        // 迭代器遍历
        while (iterator.hasNext()) {
            String nextStr = iterator.next();
            if (!strRecord.contains(nextStr)) {
                tempList.add(nextStr);
                strRecord += nextStr;
            }
        }
        // 将辅助集合的元素转化为String数组,用于后续操作
        String[] array = tempList.toArray(new String[tempList.size()]);
        // 直接输出最终的字符串
        System.out.println(strRecord);
    }
}
