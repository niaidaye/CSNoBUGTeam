package _02leetcode.num21;

/**
 * Descripsion:
 *
 * @Author dengp
 * @create 2023/11/11 17:43
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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(-1);
        ListNode p = dummy;

        ListNode p1 = list1, p2 = list2;
        // 如果p1 与 p2 都不为空，那么循环合并
        while (p1 != null && p2 != null) {
            // p1节点值 大于 p2节点值,则将p1节点插入到p的下一节点
            if (p1.val > p2.val) {
                p.next = p1;
                // p1 指向p1链表的下一节点
                p1 = p1.next;
            } else {
                // 否则将p2节点插入到p的下一节点，p2指针指向链表的下一节点
                p.next = p2;
                p2 = p2.next;
            }
            // p指向下一节点
            p = p.next;
        }
        // 如果循环结束p1链表中还有节点
        if (p1 != null) {
            // 直接将p的next指针指向p1剩余节点
            p.next = p1;
        }
        if (p2 != null) {
            p.next = p2;
        }

        // 至此，两个链表已经合并完毕
        // 因为dummy节点值是-1，所以直接返回dummy的下一节点，该节点指向链表的起点.
        return dummy.next;

    }
}