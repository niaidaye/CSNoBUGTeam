package com.csnobugteam.java.homework.day28;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 1, 给定一个数字列表, 如何返回一个由每个数的平方构成的列表?
 * // [1,2,3,4,5] -> [1,4,9,16,25]
 * List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
 *
 * @author aixu
 * @since 2023/11/16
 */
public class ReturnNumsHomeWork {
    public List<Integer> ReturnNumSquares(List<Integer> list) {
        return list.stream().map(integer -> integer * integer).collect(Collectors.toList());
    }
}
