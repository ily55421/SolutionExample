/*
 * @lc app=leetcode.cn id=206 lang=java
 *
 * [206] 反转链表
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
package com.leetcode.tip05LinkedList;

class Solution206 {
    public static void main(String[] args) {
        ListNode listNode = new ListNode();
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(1);
        ListNode listNode4 = new ListNode(2);
        listNode.next = listNode1;
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        ListNode listNode5 = reverseList(listNode);
        System.out.println(listNode5);
    }
    public static ListNode reverseList(ListNode head) {
        ListNode dummy = new ListNode();
        while (head != null) {
            ListNode tmp = head.next;
            // 先将head的后继节点 赋值给新插入的几点   实现尾插效果 再进行遍历
            head.next = dummy.next;
            dummy.next = head;
            // 向后遍历
            head = tmp;
        }
        return dummy.next;
    }
}
// @lc code=end

