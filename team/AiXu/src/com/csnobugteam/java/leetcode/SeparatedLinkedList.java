package com.csnobugteam.java.leetcode;

import com.csnobugteam.java.utils.ListNode;

/**
 * LeetCode第86题分隔链表
 * 给你一个链表的头节点 head 和一个特定值 x ，请你对链表进行分隔，使得所有 小于 x 的节点都出现在 大于或等于 x 的节点之前。
  * 你应当 保留 两个分区中每个节点的初始相对位置。
 * @author aixu
 * @since 2023/11/13
 */
public class SeparatedLinkedList {
     public ListNode partition(ListNode head, int x) {
         // 设置两个哨兵
         ListNode dummy1 = new ListNode(-1),p1 = dummy1;
         ListNode dummy2 = new ListNode(-1),p2 = dummy2;
         // 设置头指针p
         ListNode p = head;

         // 进行遍历链表
         while (p != null) {
             // 进行比较X值，
             if(p.val < x) {
                 p1.next = p;
                 p1 = p1.next;
             } else {
                 p2.next = p;
                 p2 = p2.next;
             }
             // 进行p指针移动
             ListNode temp = p.next;
             p.next = null;
             p = temp;
         }

         // 合并
         p1.next = dummy2.next;

         return dummy1.next;
     }
}
