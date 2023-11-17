package _01work.com.csnobug.dsdb.day04.work03;

import java.util.ArrayList;

/**
 * @author brother-deng
 * @version 1.0
 * @create 2023/11/13 21:40
 */
/*
假设有一个字符串"abcqweracb" 在不改变前后顺序的前提下去除重复的字符得到"abcqwer"(结合使用ArrayList)
 */
public class Demo {
    public static void main(String[] args) {

        ArrayList<Character> list = new ArrayList<>();
        String s = "abcqweracb";
        char[] arr = new char[s.length()];
        // 循环找每一个字符，看是否有重复
        for (int i = 0; i < arr.length; i++) {
            arr[i] = s.charAt(i);
            // 如果没有重复字符，则加入list中
            if (!list.contains(arr[i])) {
                list.add(arr[i]);
            }
        }
        System.out.println(list);
        String s1 = "";
        for (Character character : list) {
            s1 += character;
        }
        System.out.println(s1);
    }
}
