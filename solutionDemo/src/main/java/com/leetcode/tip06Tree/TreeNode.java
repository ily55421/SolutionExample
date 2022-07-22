package com.leetcode.tip06Tree;

/**
 * @Author: linK
 * @Date: 2022/7/22 10:25
 * @Description TODO 树节点结构体
 */
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
