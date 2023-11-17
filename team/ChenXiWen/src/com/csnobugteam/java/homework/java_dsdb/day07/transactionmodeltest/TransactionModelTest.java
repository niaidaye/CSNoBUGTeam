package com.csnobugteam.java.homework.java_dsdb.day07.transactionmodeltest;

import org.junit.Test;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * 基于提供的三个参考类型: 实现
 * // 找出2011年发生的交易记录, 按照从低到高交易额排序
 * // 找出交易员都在哪些不同的城市工作过的城市
 * // 查找来自北京的交易, 按交易员姓名排序
 * // 返回一个字符串包含所有交易员, 字符串的顺序按照姓名排序
 * // 判断有没有交易员在北京工作
 * // 打印所有发生在北京的交易记录金额
 * // 所有交易中最高的交易是多少
 * // 所有交易中, 交易最低的交易信息
 * @auther cxw
 * @since 2023/11/16
 */
public class TransactionModelTest {
    // 找出2011年发生的交易记录, 按照从低到高交易额排序
    @Test
    public void transactionRecordSorting() {
        List<Transaction> list = TransactionRecord.transactions;
        list.stream()
                .filter(transaction -> transaction.getYear() == 2011)
                .sorted(((o1, o2) -> o1.getValue() - o2.getValue()))
                .forEach(System.out::println);
    }

    // 找出交易员都在哪些不同的城市工作过的城市
    @Test
    public void findUniqueCitiesOfTraders() {
        List<Transaction> list = TransactionRecord.transactions;
        list.stream()
                .map(transaction -> transaction.getTrader().getCity())
                .distinct()
                .forEach(System.out::println);
    }

    // 查找来自北京的交易, 按交易员姓名排序
    @Test
    public void findTransactionsFromBeijingSortedByTraderName() {
        List<Transaction> list = TransactionRecord.transactions;
        List<Transaction> collect = list.stream()
                .filter(transaction -> "beijing".equals(transaction.getTrader().getCity()))
                .sorted((o1, o2) -> o1.getTrader().getName().compareTo(o2.getTrader().getName()))
                .collect(Collectors.toList());
        System.out.println(collect);
    }

    // 返回一个字符串包含所有交易员, 字符串的顺序按照姓名排序
    @Test
    public void getAllTradersSortedByName() {
        List<Transaction> list = TransactionRecord.transactions;
        Optional<String> reduce = list.stream()
                .map(transaction -> transaction.getTrader().toString())
                .sorted(String::compareTo)
                .distinct()
                .reduce((o1, o2) -> o1 + o2);
        String string = null;
        if (reduce.isPresent()) {
            string = reduce.get();
        }
        System.out.println(string);
    }

    // 判断有没有交易员在北京工作
    @Test
    public void isTraderWorkingInBeijing() {
        List<Transaction> list = TransactionRecord.transactions;
        boolean anyMatch = list.stream()
                .anyMatch(transaction -> "beijing".equals(transaction.getTrader().getCity()));
        if (anyMatch) {
            System.out.println("有在北京工作的交易员");
        } else {
            System.out.println("没有在北京工作的交易员");
        }
    }

    // 打印所有发生在北京的交易记录金额
    @Test
    public void printTransactionAmountsInBeijing() {
        List<Transaction> list = TransactionRecord.transactions;
        list.stream()
                .filter(transaction -> "beijing".equals(transaction.getTrader().getCity()))
                .forEach(transaction -> System.out.println(transaction.getValue()));

    }

    // 所有交易中最高的交易是多少
    @Test
    public void getHighestTransactionAmount() {
        List<Transaction> list = TransactionRecord.transactions;
        Optional<Integer> reduce = list.stream()
                .map(Transaction::getValue)
                .reduce(Math::max);
        reduce.ifPresent(System.out::println);
    }

    // 所有交易中, 交易最低的交易信息
    @Test
    public void getLowestTransaction() {
        List<Transaction> list = TransactionRecord.transactions;
        // 方式一：reduce
        Optional<Transaction> reduce = list.stream()
                .reduce((o1, o2) -> o1.getValue() < o2.getValue() ? o1 : o2);
        reduce.ifPresent(System.out::println);
        // 方式二：
        Optional<Transaction> first = list.stream()
                .sorted((o1, o2) -> o1.getValue() - o2.getValue())
                .findFirst();
        first.ifPresent(System.out::println);
    }

}
