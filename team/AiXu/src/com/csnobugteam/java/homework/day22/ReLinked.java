package com.csnobugteam.java.homework.day22;

import com.csnobugteam.java.utils.Node;

/**
 * 1, 如果存在一个单链表,实现一个方法, 给定这个单链表的头结点, 获得这个链表经过反序之后链表的头结点
 *
 * @author aixu
 * @since 2023/11/9
 */
public class ReLinked {
    public static void main(String[] args) {
        // 翻转链表
        // a --> b --> c --> d --> e
        Node e = new Node("e");
        Node d = new Node("d", e);
        Node c = new Node("c", d);
        Node b = new Node("b", c);
        Node a = new Node("a", b);

        // e  --> d  -->  c  --> b  --> a
        Node newLinked = reLinked(a);

        System.out.println(newLinked.val);
    }
    /**
     * 翻转链表
     * @param head : 原链表头结点
     * @return : 经过翻转链表的头结点
     */
    private static Node reLinked(Node head) {
        // 待排序的节点
        Node prev = null;
        // 当前节点
        Node current = head;

        // 进行，当前节点遍历，如果为null 代表，单链表结束
        while (current != null) {
            // 思路：将当前节点，与下一个节点值，进行交换
            // 临时节点，存放下个节点
            Node temp = current.next;
            // 将下个节点的引用赋给待排的节点
            current.next = prev;
            // 进行交换，
            prev = current;
            // 当前节点指向，下个节点
            current = temp;
        }

        return prev;
    }


}