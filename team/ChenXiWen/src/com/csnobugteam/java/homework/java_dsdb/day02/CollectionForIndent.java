package com.csnobugteam.java.homework.java_dsdb.day02;

import java.io.DataOutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;


/**
 * 有一批订单信息，订单信息包括 下单人，下单金额，下单时间
 * 1.现在想找出最大的下单金额对应的下单人
 * 2.想找出2022-2023年下单的所有订单信息
 * 3.删除低于平均下单金额的账单
 * @auther cxw
 * @since 2023/11/10
 */
public class CollectionForIndent {
    public static void main(String[] args) {
        ArrayList<Indent> list = new ArrayList<>();
        list.add(new Indent("zs", 800, "2021/2/3"));
        list.add(new Indent("ls", 2380, "2022/4/3"));
        list.add(new Indent("ww", 1800, "2023/2/3"));
        list.add(new Indent("ax", 900, "2020/2/3"));
        list.add(new Indent("hj", 600, "2022/2/8"));


        // 查找最大金额对应的下单人
        Collection<?> maxAmountPerson = findMaxAmountPerson(list);
        System.out.println(maxAmountPerson);

        // 查找2022-2023年下单的订单
        Collection<Indent> specifiedTimeAmount = findSpecifiedTimeAmount(list);
        System.out.println(specifiedTimeAmount);

        // 删除低于平均下单金额的账单
        deleteBelowAmountList(list);
        System.out.println(list);

    }

    private static void deleteBelowAmountList(ArrayList<Indent> list) {
        double sum = 0;
        double averageAmount = 0;
        Iterator<Indent> iterator = list.iterator();
        while (iterator.hasNext()) {
            Indent indent = iterator.next();
            sum += indent.amount;
        }
        averageAmount = sum / list.size();
        System.out.println("平均下单金额为：" + averageAmount);

        ArrayList<Indent> indents = new ArrayList<>();
        for (Indent indent : list) {
            if (indent.amount < averageAmount) {
                indents.add(indent);
            }
        }
        for (Indent indent : indents) {
            list.remove(indent);
        }
    }

    private static Collection<Indent> findSpecifiedTimeAmount(ArrayList<Indent> list) {
        ArrayList<Indent> indents = new ArrayList<>();
        Iterator<Indent> iterator = list.iterator();
        while (iterator.hasNext()) {
            Indent indent = iterator.next();
            String[] split = indent.date.split("/");
            if ("2022".equals(split[0]) || "2023".equals(split[0])) {
                indents.add(indent);
            }
        }
        return indents;
    }

    private static Collection<?> findMaxAmountPerson(ArrayList<Indent> list) {
        double maxScore = 0;
        Iterator<Indent> iterator = list.iterator();
        while (iterator.hasNext()) {
            Indent indent = iterator.next();
            if (maxScore < indent.amount) {
                maxScore = indent.amount;
            }
        }
        ArrayList<Indent> maxAmountPerson = new ArrayList<>();
        for (Indent indent : list) {
            if (indent.amount == maxScore) {
                maxAmountPerson.add(indent);
            }
        }
        return maxAmountPerson;
    }
}

class Indent {
    String name;
    double amount;
    String date;

    public Indent(String name, double amount, String date) {
        this.name = name;
        this.amount = amount;
        this.date = date;
    }

    @Override
    public String toString() {
        return "Indent{" +
                "name='" + name + '\'' +
                ", amount=" + amount +
                ", date='" + date + '\'' +
                '}';
    }
}