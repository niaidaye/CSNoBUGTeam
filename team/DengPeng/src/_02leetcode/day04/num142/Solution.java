package _02leetcode.day04.num142;

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}

public class Solution {
    public ListNode detectCycle(ListNode head) {
        // 定义快慢指针
        ListNode slow = head, fast = head;

        // 检测到有环，或者无环就退出循环
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                break;
            }
        }

        // 校验是有环，还是无环的情况
        if (fast == null || fast.next == null) {
            // 无环就退出
            return null;
        }

        // 有环继续执行，将快指针指向头节点，并且放慢速度。
        fast = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }

        // 找到了再次相遇的地方，这个时候，fast与slow节点都在环起点处相遇
        return fast;
    }
}