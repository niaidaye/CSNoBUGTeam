package _01work.com.csnobug.dsdb.day07.work02;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author brother-deng
 * @version 1.0
 * @create 2023/11/16 18:28
 */
public class Demo {
    /*
    1, 给定一个数字列表, 如何返回一个由每个数的平方构成的列表?
        // [1,2,3,4,5] -> [1,4,9,16,25]
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
     */
    @Test
    public void test1() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);

        System.out.println(list);

        // 使用stream操作
        List<Integer> collect = list.stream()
                .map(integer -> integer * integer)
                .collect(Collectors.toList());

        System.out.println(collect);
    }
}
