package com.csnobugteam.java.homework.java_dsdb.day01.linkedcircle;

/**
 * @auther cxw
 * @since 2023/11/9
 */
public class LinkedListWork {
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
     * 判断单链表是否有环
     * @param head : 头结点
     * @return : 是否有环
     */
    private static boolean hasCircle(Node head) {
        // 若为空链表，则返回false
        if (head.next == null) {
            return false;
        }
        // 定义一个辅助指针temp，用于遍历链表
        Node temp = head.next;
        // 定义一个字符串，用于拼接所遍历节点的data
        String dataCollect = head.data;
        // 遍历链表，若在dataCollect中能找到下一个结点的data，说明之前已经遍历过，即存在链表环
        while (temp.next != null) {
            if (dataCollect.contains(temp.data)) {
                return false;
            }
            dataCollect += temp.data;
            temp = temp.next;
        }
        // 不存在环则退出循环，返回true
        return true;
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
}

