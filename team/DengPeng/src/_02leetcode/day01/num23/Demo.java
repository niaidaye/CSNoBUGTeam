package _02leetcode.day01.num23;

/**
 * Descripsion:
 *
 * @Author dengp
 * @create 2023/11/10 0:05
 * @Version 1.0
 */
public class Demo {
    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode listNode1 = new ListNode(1, new ListNode(4, new ListNode(5)));
        ListNode listNode2 = new ListNode(1, new ListNode(3, new ListNode(4)));
        ListNode listNode3 = new ListNode(2, new ListNode(6));
        ListNode listNode = solution.mergeKLists(new ListNode[]{listNode1, listNode2, listNode3});
    }
}
