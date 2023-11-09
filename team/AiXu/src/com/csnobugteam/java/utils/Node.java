package com.csnobugteam.java.utils;

/**
 * 单链表头节点
 * @author aixu
 * @since 2023/11/9
 */
public class Node {
    // 值
    public String val;
    public Node next;

    public Node(String val) {
        this.val = val;
        this.next = null;
    }

    public Node(String val, Node next) {
        this.val = val;
        this.next = next;
    }
}
