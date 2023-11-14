package src.homework.day4.homework;

/*
 * @Description:
 * @Author: LN
 *  @Date : 2023/11/13
 */


import java.util.ArrayList;
import java.util.List;

/*
假设有一个字符串"abcqweracb" 在不改变前后顺序的前提下去除重复的字符得到"abcqwer"(结合使用ArrayList)
 */
public class Demo2 {
    public static void main(String[] args) {
        // 1:先定义一个string类型的字符串
        String str = "abcqweracb";

        // 2：创建一个集合数组
        List<String> list = new ArrayList<>();
        // 3：遍历字符串
        for (int i = 0; i < str.length(); i++) {
            // 4：截取str中从startIndex 开始至endIndex结束时的字符串，并赋值给str
            String s = str.substring(i, i + 1);

            // 当list调用contains（）方法并传递一个元素时，会执行遍历，逐个对比是否等于该元素，
            // 当遍历结束后，如果还没有一个元素等于该元素的值，则返回false, 否则返回true
            if (!list.contains(s)) {
                list.add(s);

            }
        }
        // 定义一个 string 类型的空字符串
        String resul = "";
        // 循环去掉重复的字符串数组
        for (String s : list) {
        // 依次加入到空字符串里
            resul += s;

        }
        // 最后返回去除重复的值
        System.out.println(resul);

    }


}

