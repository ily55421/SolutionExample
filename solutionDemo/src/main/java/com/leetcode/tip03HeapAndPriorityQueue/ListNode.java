package com.leetcode.tip03HeapAndPriorityQueue;

/**
 * @Author: linK
 * @Date: 2022/7/22 9:46
 * @Description TODO 列表节点
 */
public class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public ListNode getNext() {
        return next;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
