package _02leetcode.num23;

import java.util.PriorityQueue;

/**
 * Descripsion:
 *
 * @Author dengp
 * @create 2023/11/9 23:02
 * @Version 1.0
 */

public class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        // 如果链表数组长度为0，那么代表数组中为null，返回null
        if (lists.length == 0) {
            return null;
        }
        // dummy设置一个虚拟头节点
        ListNode dummy = new ListNode(-1);
        ListNode p = dummy;

        // 这里可以使用PrioityQueue优先级队列实现自动排序
        // PriorityQueue(int initialCapacity, Comparator<? super E> comparator)
        // 使用指定的初始容量创建一个 PriorityQueue，并根据指定的比较器对元素进行排序。
        // 后面是重写Comparator接口中的compare方法
        PriorityQueue<ListNode> pq = new PriorityQueue<>(lists.length, (a, b) -> (a.val - b.val));

        // 将ListNode数组中存储的节点插入按照val的值排序的小根堆中
        for (ListNode list : lists) {
            if (list != null) {
                pq.add(list);
                // pq永远指向堆顶元素
            }
        }

        // 循环获取最小节点，插入结果链表中
        // 判断pq队列是否为null
        while (!pq.isEmpty()) {
            // poll方法获取并移除此队列的头，如果此队列为空，则返回 null。
            ListNode node = pq.poll();
            p.next = node;
            // 判断node的next是否为null，如果为null，则不接入结果链表；
            // 如果不为null，则将node的next节点赋给pq，实现while循环选择节点接入结果链表
            if (node.next != null) {
                // pq队列里面装的是诸多分链表的第一个节点，所以也是按照诸多链表的第一个节点的val值进行小根堆排序
                pq.add(node.next);
            }
            p = p.next;
        }

        return dummy.next;

    }
}