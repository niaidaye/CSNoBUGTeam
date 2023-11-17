package com.csnobugteam.java.homework.day22;

import com.csnobugteam.java.utils.Node;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * 1,如果存在一个单链表, 我们只拥有单链表的头结点, 实现一个方法, 判断链表中是否有环 (即: 这个单链表的尾结点, 它下一个指向, 指向链表中的另外一个结点, 构成一个环)
 *
 * @author aixu
 * @since 2023/11/9
 */
public class HasCircle {// 用于存放，遍历中，节点值
    static Set<String> hashSet = new HashSet<>();

    public static void main(String[] args) {
        // a --> b --> c --> d --> e
        Node e = new Node("e");
        Node d = new Node("d", e);
        Node c = new Node("c", d);
        Node b = new Node("b", c);
        Node a = new Node("a", b);

        // a --> b --> c --> d --> e --> c --> d --> e --> ...
        e.next = c;

        boolean bool = hasCircle(a);
        System.out.println(bool);
    }

    /**
     * 判断链表是否有环
     *
     * @param head : 头结点
     * @return : 是否有环
     */
    private static boolean hasCircle(Node head) {
        boolean flag = true;
        // 将节点值，存储入hashSet中
        while (!Objects.equals(head, null)) {
            head = head.next;
            // 进行Set集合筛选，如果，递归到重复元素就代表重复，间接代表，有环
            if (!hashSet.add(head.val)) {
                flag = false;
                break;
            }
        }

        return flag;
    }

    // 老师的代码
//    private static boolean hasCircle(Node head) {
//        Node l = head; // 慢指针
//        Node f = head; // 快指针
//
//
//        // 判断快指针是否向后为null
//        // 不是null , 意味着还没有到尾部 --> 接着向后走
//        while (f.next != null && f.next.next != null){
//            f = f.next.next;
//            l = l.next;
//
//            // 判断快指针和慢指针是否重合 --> 重合意味着有环
//            if (f == l){
//                return true;
//            }
//        }
//
//
//        return false;
//    }

}

