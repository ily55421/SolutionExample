/*
 * @lc app=leetcode.cn id=19 lang=java
 *
 * [19] 删除链表的倒数第 N 个结点
 *
 * https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/description/
 *
 * algorithms
 * Medium (41.16%)
 * Likes:    1258
 * Dislikes: 0
 * Total Accepted:    334.9K
 * Total Submissions: 812.9K
 * Testcase Example:  '[1,2,3,4,5]\n2'
 *
 * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 * 
 * 进阶：你能尝试使用一趟扫描实现吗？
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：head = [1,2,3,4,5], n = 2
 * 输出：[1,2,3,5]
 * 
 * 
 * 示例 2：
 * 
 * 
 * 输入：head = [1], n = 1
 * 输出：[]
 * 
 * 
 * 示例 3：
 * 
 * 
 * 输入：head = [1,2], n = 1
 * 输出：[1]
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 链表中结点的数目为 sz
 * 1 
 * 0 
 * 1 
 * 
 * 
 */

// @lc code=start
package com.leetcode.tip05LinkedList;


/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode() {} ListNode(int val) { this.val = val; } ListNode(int val,
 * ListNode next) { this.val = val; this.next = next; } }
 */

class Solution19 {
    public ListNode removeNthFromEnd(ListNode head, int k) {
        // 将链表改造成带假头的链表
        ListNode dummy = new ListNode();
        dummy.next = head;

        // 链表长度
        int preWalkedSteps = 0;
        // front指针从dummy开始先走k步
        ListNode front = dummy;
        // 注意front不能为空，需要指向链表的最后一个结点
        while (preWalkedSteps < k && front != null && front.next != null) {
            front = front.next;
            preWalkedSteps++;
        }

        // back指针指向dummy，然后front与back指针一起走
        ListNode back = dummy;
        // 注意front不能为空，需要指向链表的最后一个结点
        while (front != null && front.next != null) {
            back = back.next;
            front = front.next;
        }

        // 如果preWalkedSteps == k
        // 说明处于情况2和情况3，需要删除倒数第k个结点
        if (preWalkedSteps == k) {
            back.next = back.next.next;
        }

        // 返回新的链表头
        return dummy.next;
    }
}
// @lc code=end
