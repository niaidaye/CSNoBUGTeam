package src.homework.day7;

/*
 * @Description:
 * @Author: LN
 *  @Date : 2023/11/16
 */

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static src.homework.day7.TransactionRecord.transactions;


/*
 基于提供的三个参考类型: 实现
 找出2011年发生的交易记录, 按照从低到高交易额排序
 找出交易员都在哪些不同的城市工作过的城市
 查找来自北京的交易, 按交易员姓名排序
 返回一个字符串包含所有交易员, 字符串的顺序按照姓名排序
 判断有没有交易员在北京工作
 打印所有发生在北京的交易记录金额
 所有交易中最高的交易是多少
 所有交易中, 交易最低的交易信息
 */
public class Demo2 {
    public static void main(String[] args) {
        // 1: 找出2011年发生的交易记录, 按照从低到高交易额排序

        //首先获取流
        Stream<Transaction> stream = transactions.stream();

        // 用filter过滤  方法找出2011年的交易记录
        List<Transaction> collect = stream.filter(Transaction -> Transaction.getYear() == 2011).sorted(new Comparator<Transaction>() {

            // 重写方法
            @Override
            public int compare(Transaction o1, Transaction o2) {

                // 返回从低到高的值
                return o1.getValue() - o2.getValue();
            }

            // 返回排序之后的list
        }).collect(Collectors.toList());

        // 打印结果
        System.out.println(collect);


        //   2: 找出交易员都在哪些不同的城市工作过的城市

        // 首先获取流
        Stream<Transaction> stream1 = transactions.stream();

        // 转换流，把人转换成城市；map
        List<String> collect1 = stream1.map(new Function<Transaction, String>() {

            @Override
            public String apply(Transaction transaction) {
                return transaction.getTrader().getCity();
            }
            // distinct：是去重复的
        }).distinct().collect(Collectors.toList());

        System.out.println(collect1);


        // 3: 查找来自北京的交易, 按交易员姓名排序
        Stream<Transaction> stream2 = transactions.stream();

        List<Transaction> collect2 = stream2.filter(Transaction -> Transaction.getTrader().getCity().equals("beijing")).sorted(new Comparator<Transaction>() {
            @Override
            public int compare(Transaction o1, Transaction o2) {
                return o1.getTrader().getName().compareTo(o2.getTrader().getName());
            }
        }).collect(Collectors.toList());

        System.out.println(collect2);


        // 4:  返回一个字符串包含所有交易员, 字符串的顺序按照姓名排序
        Stream<Transaction> stream3 = transactions.stream();
        List<String> collect3 = stream3.map(new Function<Transaction, String>() {
            @Override
            public String apply(Transaction transaction) {
                return transaction.getTrader().getName();

            }
        }).sorted(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        }).collect(Collectors.toList());

        System.out.println(collect3);


        //     5:判断有没有交易员在北京工作
        Stream<Transaction> stream4 = transactions.stream();

        long beijing = stream4.filter(transaction -> transaction.getTrader().getCity().equals("beijing")).count();

        if (beijing > 0) {
            System.out.println("有" + beijing + "个交易员在北京");

        } else {
            System.out.println("没有交易员在北京");

        }



        // 6: 打印所有发生在北京的交易记录金额

        Stream<Transaction> stream5 = transactions.stream();
        List<Integer> beijing1 = stream5.filter(Transaction -> Transaction.getTrader().getCity().equals("beijing")).map(new Function<Transaction, Integer>() {
            @Override
            public Integer apply(Transaction transaction) {
                return transaction.getValue();
            }
        }).collect(Collectors.toList());

        System.out.println(beijing1);

        // 7: 所有交易中最高的交易是多少
        Stream<Transaction> stream6 = transactions.stream();

        Optional<Transaction> max = stream6.max(new Comparator<Transaction>() {
            @Override
            public int compare(Transaction o1, Transaction o2) {
                return o1.getValue() - o2.getValue();
            }
        });
        System.out.println(max.get());

        // 8: 所有交易中, 交易最低的交易信息
        Stream<Transaction> stream7 = transactions.stream();
        Optional<Transaction> min = stream7.min(new Comparator<Transaction>() {
            @Override
            public int compare(Transaction o1, Transaction o2) {
                return o1.getValue() - o2.getValue();
            }
        });
        System.out.println(min.get());

    }
}

