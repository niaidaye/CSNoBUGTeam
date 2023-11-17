package src.homework.day5;

/*
 * @Description:
 * @Author: LN
 *  @Date : 2023/11/14
 */


/*
给定两个字符串s和t, 它们只包含小写字母。字符串t是由s中的字母随机打乱之后，
在随机的一个位置添加一个字母生成的。请找出那个添加的字母。
比如：
s = "abcd"
t = "baedc"
输出：e
 */
public class Demo1 {
    public static void main(String[] args) {
        // 首先定义 s 和 t 两个字符串
        String s = "abcd";
        String t = "baedc";

        // 定义一个方法，用于找出添加的字母
        char addLetters = findAddLetters(s, t);

        // 打印结果
        System.out.println(addLetters);


    }

    private static char findAddLetters(String s, String t) {
        // 定义初始化为 0
        char result = 0;

        // 遍历 s  字符串数组
        for (char c : s.toCharArray()) {
            result ^= c;
        }

        // 遍历 t 字符串数组
        for (char c : t.toCharArray()) {
            result ^= c;
        }

        return result;
    }
}

