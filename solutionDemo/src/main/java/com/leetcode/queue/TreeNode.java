package com.leetcode.queue;

/**
 * @Author: linK
 * @Date: 2022/7/21 15:03
 * @Description TODO 二叉树的定义
 */
public class TreeNode {
    // 树结点中的元素值
    int val = 0;
    // 二叉树结点的左子结点
    TreeNode left = null;
    // 二叉树结点的右子结点
    TreeNode right = null;
    /**
     * 右节点
     */
    TreeNode next = null;

    /**
     * 增加空参和全参构造
     */
    TreeNode() {
    }

    TreeNode(int x) {
        val = x;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
