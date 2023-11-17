package com.csnobugteam.java.homework.day28;

import org.junit.Test;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

// 找出2011年发生的交易记录, 按照从低到高交易额排序
// 找出交易员都在哪些不同的城市工作过的城市
// 查找来自北京的交易, 按交易员姓名排序
// 返回一个字符串包含所有交易员, 字符串的顺序按照姓名排序
// 判断有没有交易员在北京工作
// 打印所有发生在北京的交易记录金额
// 所有交易中最高的交易是多少
// 所有交易中, 交易最低的交易信息
public class TransactionRecordTest {
    List<Transaction> transactions = TransactionRecord.transactions;

    // 找出2011年发生的交易记录, 按照从低到高交易额排序
    @Test
    public void getTransactionsIn2011SortedByValue() {
        List<Transaction> collected = transactions.stream()
                .filter(transaction -> transaction.getYear() == 2011)
                .sorted((o1, o2) -> o1.getValue() - o2.getValue())
                .collect(Collectors.toList());
        collected.forEach(transaction -> System.out.println(transaction.toString()));
    }

    // 找出交易员都在哪些不同的城市工作过的城市
    @Test
    public void getDistinctCitiesOfWorkingTraders() {
        Set<String> collect = transactions.stream()
                .map(transaction -> transaction.getTrader().getCity())
                .collect(Collectors.toSet());
        collect.forEach(System.out::println);
    }

    // 查找来自北京的交易, 按交易员姓名排序
    @Test
    public void getTransactionsFromBeijingSortedByName() {
        List<Transaction> transactionList = transactions.stream()
                .filter(transaction -> "beijing".equals(transaction.getTrader().getCity()))
                .sorted(Comparator.comparing(transaction -> transaction.getTrader().getName()))
                .collect(Collectors.toList());
        transactionList.forEach(System.out::println);
    }

    // 返回一个字符串包含所有交易员, 字符串的顺序按照姓名排序
    @Test
    public void getAllTradersAsStringSortedByName(){
        Optional<String> names = transactions.stream()
                .sorted(Comparator.comparing(transaction -> transaction.getTrader().getName()))
                .map(transaction -> transaction.getTrader().getName())
                .reduce(((s1, s2) -> s1 + " , " + s2));
        names.ifPresent(System.out::println);
    }

    // 判断有没有交易员在北京工作
    @Test
    public void hasTraderInBeijing(){
        boolean traderInBeijing = transactions.stream().anyMatch(transaction -> {
            return "beijing".equals(transaction.getTrader().getCity());
        });
        System.out.println(traderInBeijing);
    }

    // 打印所有发生在北京的交易记录金额
    @Test
    public void printBeijingTransactionsValue(){
        List<Integer> collect = transactions.stream()
                .filter(transaction -> "beijing".equals(transaction.getTrader().getCity()))
                .map(Transaction::getValue)
                .collect(Collectors.toList());

        collect.forEach(System.out::println);
    }

    // 所有交易中最高的交易是多少
    @Test
    public void printMaxTransactionValue(){
        Optional<Integer> maxValue = transactions.stream()
                .max((o1, o2) -> Math.max(o1.getValue(), o2.getValue())).map(Transaction::getValue);
        maxValue.ifPresent(System.out::println);
    }

    // 所有交易中, 交易最低的交易信息
    @Test
    public void getMinimumTransaction(){
        Optional<Transaction> miniMumTransaction = transactions.stream()
                .min((o1, o2) -> Math.min(o1.getValue(), o2.getValue()));
        miniMumTransaction.ifPresent(System.out::println);
    }
}