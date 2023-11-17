package DayList.linkedlist.homework;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * @Projectname: CSNoBUGTeam
 * @Filename:
 * @Author: an
 * @Data:2023/11/13 8:09 PM
 * @Description: TODO
 */
/*假设有一个字符串"abcqweracb" 在不改变前后顺序的前提下
去除重复的字符得到"abcqwer"(结合使用ArrayList*/
public class Demo {

    @Test//采用迭代器求解
    public void test1() {
        ArrayList<Character> arrayList = new ArrayList<>();
        String input = "abcqweracb";
        //可以采用遍历方式
        Iterator<Character> iterator = input.chars().mapToObj(c -> (char) c).iterator();
        /*input.chars(): 这返回一个 IntStream，它是原始 int 值的序列。在这里，它代表了input字符串中字符的 Unicode 代码点。
.mapToObj(c -> (char) c): 这将每个整数代码点映射到相应的字符，
通过将其转换为 char。结果是一个 ObjectStream<Character>，实质上是一个字符流。
.iterator(): 这将 ObjectStream<Character> 转换为一个 Iterator。Iterator 是 Java 中的一个接口，
提供了在元素集合上进行迭代的方法。在这里，它允许我们迭代从字符串中获取的字符。
所以，整个表达式创建了一个迭代器，该迭代器通过首先获得字符串中 Unicode 代码点的 IntStream，将其转换为字符的 ObjectStream，
然后从该流中获取一个迭代器，从而实现对字符串中字符的迭代。*/
        while (iterator.hasNext()) {
            char currentchar = iterator.next();
            if (!arrayList.contains(currentchar)) {
                arrayList.add(currentchar);
            }
        }
        System.out.println(arrayList);
    }

    @Test//遍历for循环求解

    public void test2() {
        ArrayList<Character> arrayList = new ArrayList<>();
        String input = "abcqweracb";
        for (int i = 0; i < input.length(); i++) {
            char currentChar = input.charAt(i);
            if (!arrayList.contains(currentChar)) {
                arrayList.add(currentChar);
            }
        }

        System.out.println(arrayList);
    }
@Test//增强for循环求解
    public void test3(){
    ArrayList<Character> arrayList = new ArrayList<>();
    String input = "abcqweracb";
    for (char currentchar:
         input.toCharArray()) {
        if(!arrayList.contains(currentchar)){
            arrayList.add(currentchar);
        }
        
    }
    System.out.println(arrayList);
}
}
