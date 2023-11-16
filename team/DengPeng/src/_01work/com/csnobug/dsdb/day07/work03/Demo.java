package _01work.com.csnobug.dsdb.day07.work03;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.function.Supplier;
import java.util.stream.Collectors;

/**
 * @author brother-deng
 * @version 1.0
 * @create 2023/11/16 19:16
 */
/*
2, 基于提供的三个参考类型: 实现
    1.1 找出2011年发生的交易记录, 按照从低到高交易额排序
    1.2 找出交易员都在哪些不同的城市工作过的城市
    1.3 查找来自北京的交易, 按交易员姓名排序
    1.4 返回一个字符串包含所有交易员, 字符串的顺序按照姓名排序
    1.5 判断有没有交易员在北京工作
    1.6 打印所有发生在北京的交易记录金额
    1.7 所有交易中最高的交易是多少
    1.8 所有交易中, 交易最低的交易信息
 */
public class Demo {

    @Test
    public void testTransactionSorted() {
        // 1.1 找出2011年发生的交易记录, 按照从低到高交易额排序
        List<Transaction> transactionList = TransactionRecord.transactions;

        List<Transaction> collect = transactionList.stream()
                // 选择年份为2011年
                .filter(transaction -> transaction.getYear() == 2011)
                // 按照交易金额从小到大排序
                .sorted(((o1, o2) -> o1.getValue() - o2.getValue()))
                // 用List接收
                .collect(Collectors.toList());

        System.out.println(collect);
    }

    @Test
    public void test2() {
        // 1.2 找出交易员都在哪些不同的城市工作过的城市
        List<Transaction> transactionList = TransactionRecord.transactions;

        // 用Set集合接收，去重
        Set<String> collect = transactionList.stream()
                .map(transaction -> transaction.getTrader().getCity())
                .collect(Collectors.toSet());

        System.out.println(collect);
    }

    @Test
    public void test3() {
        // 1.3 查找来自北京的交易, 按交易员姓名排序
        List<Transaction> transactionList = TransactionRecord.transactions;

        Collection<Transaction> collect = transactionList.stream()
                // 过滤数据 --> 交易员来自北京
                .filter(transaction -> "beijing".equals(transaction.getTrader().getCity()))
                // 使用compareTo进行大小比较  比较姓名，然后按照比较结果排序
                .sorted(((o1, o2) -> o1.getTrader().getName().compareTo(o2.getTrader().getName())))
                // diy接收容器
                .collect(Collectors.toCollection(new Supplier<Collection<Transaction>>() {
                    @Override
                    public Collection<Transaction> get() {
                        return new ArrayList<>();
                    }
                }));

        System.out.println(collect);
        System.out.println(collect.getClass());
    }

    @Test
    public void test4() {
        // 1.4 返回一个字符串包含所有交易员, 字符串的顺序按照姓名排序
        List<Transaction> transactionList = TransactionRecord.transactions;
//        System.out.println(transactionList);

        List<Transaction> collect = transactionList.stream()
                // 按照姓名排序
                .sorted(((o1, o2) -> o1.getTrader().getName().compareTo(o2.getTrader().getName())))
                // List接收
                .collect(Collectors.toList());

        // 字符串接收
        String string = collect.toString();
        // 打印字符串
        System.out.println(string);
    }

    @Test
    public void test5() {
        // 1.5 判断有没有交易员在北京工作
        List<Transaction> transactionList = TransactionRecord.transactions;

        List<Boolean> collect = transactionList.stream()
                // 判断是否在北京工作，如果在返回true，如果不在返回false
                .map(transaction -> transaction.getTrader().getCity().equals("beijing"))
                .collect(Collectors.toList());

        System.out.println(collect);
    }

    @Test
    public void test6(){
        // 1.6 打印所有发生在北京的交易记录金额
        List<Transaction> transactionList = TransactionRecord.transactions;

        List<Integer> collect = transactionList.stream()
                // 选择北京地区
                .filter(transaction -> transaction.getTrader().getCity().equals("beijing"))
                // 转换成交易金额
                .map(transaction -> transaction.getValue())
                // 用List容器接收
                .collect(Collectors.toList());

        System.out.println(collect);
    }

    @Test
    public void test7(){
        // 1.7 所有交易中最高的交易是多少
        List<Transaction> transactionList = TransactionRecord.transactions;

        List<Transaction> collect = transactionList.stream()
                // 按照交易金额从大到小排序
                .sorted(((o1, o2) -> o2.getValue() - o1.getValue()))
                // 从前到后截取一个，也就是最大交易金额
                .limit(1)
                // 使用List容器接收
                .collect(Collectors.toList());

        System.out.println(collect);
    }

    @Test
    public void test8(){
        // 1.8 所有交易中, 交易最低的交易信息
        List<Transaction> transactionList = TransactionRecord.transactions;

        List<Transaction> collect = transactionList.stream()
                // 按照交易金额从小到大排序
                .sorted(((o1, o2) -> o1.getValue() - o2.getValue()))
                // 从前到后截取一个，也就是最小交易金额
                .limit(1)
                // 使用List容器接收
                .collect(Collectors.toList());

        System.out.println(collect);

    }
}
