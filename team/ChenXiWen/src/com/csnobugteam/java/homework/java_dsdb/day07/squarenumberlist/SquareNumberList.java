package com.csnobugteam.java.homework.java_dsdb.day07.squarenumberlist;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


/**
 * 给定一个数字列表, 如何返回一个由每个数的平方构成的列表?
 * [1,2,3,4,5] -> [1,4,9,16,25]
 * List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
 * @auther cxw
 * @since 2023/11/16
 */
public class SquareNumberList {
    @Test
    public void squareNumTest() {
        List<Integer> list = Arrays.asList(1,2,3,4,5);
        List<Integer> collect = list.stream().map(o -> o * o).collect(Collectors.toList());
        System.out.println(collect);
    }
}
