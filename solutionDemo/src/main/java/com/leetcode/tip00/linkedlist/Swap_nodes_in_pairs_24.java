package com.leetcode.tip00.linkedlist;

/**
 * @Author: linK
 * @Date: 2022/7/20 14:10
 * @Description TODO 24. 两两交换链表中的节点
 * <p>
 *     给你一个链表，两两交换其中相邻的节点，并返回交换后链表的头节点。你必须在不修改节点内部的值的情况下完成本题（即，只能进行节点交换）。
 * 示例 1：
 * 输入：head = [1,2,3,4]
 * 输出：[2,1,4,3]
 * 示例 2：
 * 输入：head = []
 * 输出：[]
 * 示例 3：
 * 输入：head = [1]
 * 输出：[1]
 *
 * 提示：
 * 链表中节点的数目在范围 [0, 100] 内
 * 0 <= Node.val <= 100
 *
 * ### 解题思路
 *
 * 这道题考察了两个知识点：
 *
 * 1.  对链表翻转算法是否熟悉
 * 2.  对递归算法的理解是否清晰
 *
 * 1.  将 curr 指向的下一节点保存到 next 指针；
 * 2.  curr 指向 prev，一起前进一步；
 * 3.  重复之前步骤，直到 k 个元素翻转完毕；
 * 4.  当完成了局部的翻转后，prev 就是最终的新的链表头，curr 指向了下一个要被处理的局部，而原来的头指针 head 成为了链表的尾巴。
 * </p>
 *
 */
public class Swap_nodes_in_pairs_24 {
    public ListNode getSwapNode(ListNode head) {
        if (head.next==null) {
            return head;
        }
        ListNode pre = null;
        ListNode next = null;
        while (head.next != null) {
            // 记住当前后继节点的值
            next = head.next;
            // 移位
            head.next = pre;
            pre = head;
            head = next;

        }

        return pre;
    }
    public ListNode swapPairs1(ListNode head) {
        ListNode root = new ListNode();
        root.next = head;
        ListNode p = root;
        while (head != null && head.next != null) {
            // post - post 节点
            ListNode tnode = head.next.next;
            // 交换相邻两个节点的值
            p.next = head.next;
            p.next.next = head;
            // 第三个节点爆出布标
            p.next.next.next = tnode;
            // head 重定向至 第二组节点的开头
            head = tnode;
            // p也开始重定向至 post - post
            p = p.next.next;
        }
        // 返回头节点
        return root.next;
    }

    /**
     * 递归的方式遍历
     * @param head
     * @return
     */
    public ListNode swapPairs2(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }
        ListNode ans = head.next, tnode = head.next.next;
        head.next = swapPairs2(tnode);
        // 交换的节点
        ans.next = head;
        return ans;
    }
}
class ListNode {
     int val;
    ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }