package src.homework.day7;

/*
 * @Description:
 * @Author: LN
 *  @Date : 2023/11/16
 */


import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/*
1, 给定一个数字列表, 如何返回一个由每个数的平方构成的列表?
// [1,2,3,4,5] -> [1,4,9,16,25]
List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
 */
public class Demo1 {
    public static void main(String[] args) {
        // stream 打开流，map转换流 集合里的元素，collect关闭流
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5).stream().map(s -> s * s).collect(Collectors.toList());

        System.out.println(list);

    }
}

