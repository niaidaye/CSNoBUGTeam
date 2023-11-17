package _02leetcode.day03.num19;

/**
 * Descripsion:
 *
 * @Author dengp
 * @create 2023/11/11 22:47
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
    public ListNode removeNthFromEnd(ListNode head, int n) {

        // 虚拟头节点
        ListNode dummy = new ListNode(-1);
        dummy.next = head;


        ListNode needDeleteNode = getNeedDeleteNode(head, n + 1);
        needDeleteNode.next = needDeleteNode.next.next;

        return dummy;

    }

    private ListNode getNeedDeleteNode(ListNode head, int k) {
        ListNode p1 = head, p2 = head;
        for (int i = 1; i < k; i++) {
            p2 = p2.next;
        }

        while (p2.next != null) {
            p1 = p1.next;
            p2 = p2.next;
        }
        return p1;
    }


}