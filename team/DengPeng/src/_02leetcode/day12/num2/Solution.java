package _02leetcode.day12.num2;

/**
 * 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 * @author Deng-P
 * @version 1.0
 * @create 2023/11/22 20:02
 */
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // 逆序   非空
        ListNode dummy = new ListNode(-1);
        ListNode p1 = l1, p2 = l2;
        ListNode p = dummy;
        int carry = 0; // 设置一个进位标志
        while (p1 != null || p2 != null || carry > 0) {
            int value = carry;
            if (p1 != null) {
                value += p1.val;
                p1 = p1.next;
            }

            if (p2 != null) {
                value += p2.val;
                p2 = p2.next;
            }

            carry = value / 10;
            value = value % 10;
            p.next = new ListNode(value);
            p = p.next;
        }

        return dummy.next;
    }
}


class ListNode {
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
