package _02leetcode.day05.num344;

/**
 * @author brother-deng
 * @version 1.0
 * @create 2023/11/13 22:46
 */
/*
编写一个函数，其作用是将输入的字符串反转过来。输入字符串以字符数组 s 的形式给出。

不要给另外的数组分配额外的空间，你必须原地修改输入数组、使用 O(1) 的额外空间解决这一问题。
 */
public class Solution {
    public void reverseString(char[] s) {
        if (s == null || s.length == 1) return;

        // 左右双指针
        int low = 0, high = s.length - 1;
        while (low < high) {
            char temp = s[low];
            s[low] = s[high];
            s[high] = temp;
            low++;
            high--;
        }
    }
}
