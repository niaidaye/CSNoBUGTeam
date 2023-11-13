package _02leetcode.day04.num160;

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}

public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode p1 = headA, p2 = headB;

        // 判断两者是否有null节点，有则不用继续执行
        if (p1 == null || p2 == null) {
            return null;
        }

        // 不要走3遍循环，那样会超出时间限制
        // 分别遍历完毕其中之一链表，再继续遍历另一链表，如果有相交处，那么会相等
        while (p1 != p2) {
            // p1 走一步，如果走到 A 链表末尾，转到 B 链表
            if (p1 == null) p1 = headB;
            else {
                p1 = p1.next;
            }
            // p2 走一步，如果走到 B 链表末尾，转到 A 链表
            if (p2 == null) p2 = headA;
            else {
                p2 = p2.next;
            }
        }
        return p1;
    }
}