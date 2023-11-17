package com.csnobugteam.java.homework.java_dsdb.day01.reverselinkedhead;

/**
 * @auther cxw
 * @since 2023/11/9
 */
public class ReverseLinkedHead {
    public static void main(String[] args) {
        // 翻转链表
        // a --> b --> c --> d --> e
        Node e = new Node("e");
        Node d = new Node("d", e);
        Node c = new Node("c", d);
        Node b = new Node("b", c);
        Node a = new Node("a", b);

        // e  --> d  -->  c  --> b  --> a
        //Node newLinked = reLinked1(a);
        Node newLinked = reLinked2(a);

        System.out.println(newLinked);
    }
    /**
     * 翻转链表方式一(三指针法)
     * @param head : 原链表头结点
     * @return : 经过翻转链表的头结点
     */
    private static Node reLinked1(Node head) {
        // 若为空链表，则返回该头结点
        if (head.next == null) {
            return head;
        }
        // 采用三指针法(比较暴力，谨慎使用)
        Node left = head;
        Node cur = head.next;
        Node right = cur;
        // 先将头结点置为空
        head.next = null;
        // 若cur指针指向最后一个结点则退出循环
        while (cur.next != null) {
            right = right.next;
            cur.next = left;
            left = cur;
            cur = right;
        }
        // 将最后的一个结点的next指向倒数第二个结点，完成链表的反转，此时cur指向反转后的头结点
        cur.next = left;
        return cur;
    }

    /**
     * 翻转链表方式二(头插法)
     * @param head : 原链表头结点
     * @return : 经过翻转链表的头结点
     */
    private static Node reLinked2(Node head) {
        // 若为空链表，则返回该头结点
        if (head.next == null) {
            return head;
        }
        // 定义一个指向新头结点的引用
        Node reLinked = null;
        // 定义一个辅助指针，用于遍历旧链表
        Node temp = head;
        // 定义一个临时指针记录temp的指向
        Node next = null;
        while (temp != null) {
            next = temp.next;
            temp.next = reLinked;
            reLinked = temp;
            temp = next;
        }
        return reLinked;
    }
}

// 定义一个结点类
class Node {
    String data;
    // 定义一个成员变量Node指向下一个结点
    Node next;

    public Node(String data) {
        this.data = data;
    }

    public Node(String data, Node next) {
        this.data = data;
        this.next = next;
    }

    @Override
    public String toString() {
        return "Node{" +
                "data='" + data + '\'' +
                '}';
    }
}

