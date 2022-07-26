/*
 * @lc app=leetcode.cn id=83 lang=java
 *
 * [83] 删除排序链表中的重复元素
 *
 * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list/description/
 *
 * algorithms
 * Easy (51.98%)
 * Likes:    481
 * Dislikes: 0
 * Total Accepted:    186.7K
 * Total Submissions: 358.3K
 * Testcase Example:  '[1,1,2]'
 *
 * 给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。
 * 
 * 示例 1:
 * 
 * 输入: 1->1->2
 * 输出: 1->2
 * 
 * 
 * 示例 2:
 * 
 * 输入: 1->1->2->3->3
 * 输出: 1->2->3
 * 
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
package com.leetcode.tip05LinkedList;
class Solution83 {
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
        ListNode listNode5 = deleteDuplicates(listNode);
        System.out.println(listNode5);
    }
    public static ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode();
        ListNode tail = dummy;
        ListNode p = head;

        while (p != null) {
            ListNode back = p.next;
            // 只能去除相邻两位数的重复
            if (tail == dummy || tail.val != p.val) {
                tail.next = p;
                tail = p;
            }

            p = back;
        }
        // 后继节点置为null
        tail.next = null;
        // 默认从第0个节点开始添加 tail本身的节点不包含在链表的值范围
        return dummy.next;
    }
}
// @lc code=end

