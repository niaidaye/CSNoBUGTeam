package _02leetcode.num141;

/**
 * Descripsion:
 *
 * @Author dengp
 * @create 2023/11/10 14:19
 * @Version 1.0
 */

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}

public class Solution {
    public boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next;

        if (slow == null || fast == null) {
            return false;
        }

        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }
}
