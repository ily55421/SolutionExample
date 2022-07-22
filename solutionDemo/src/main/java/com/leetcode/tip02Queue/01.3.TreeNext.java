/*
// 测试平台链接：https://leetcode-cn.com/problems/populating-next-right-pointers-in-each-node-ii/submissions/
// Definition for a TreeNode.
class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode next;

    public TreeNode() {}

    public TreeNode(int _val) {
        val = _val;
    }

    public TreeNode(int _val, TreeNode _left, TreeNode _right, TreeNode _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/
package com.leetcode.tip02Queue;
class Solution3 {
    public TreeNode connect(TreeNode root) {
        TreeNode Q = null;
        if (root != null) {
            Q = root;
        }

        while (Q != null) {
            // 下一层前驱结点
            TreeNode nextLevelPreTreeNode = null;
            // 下一层的头结点
            TreeNode nextLevelHead = null;
            // 顺序遍历当前层的每个结点
            TreeNode curLevelTreeNode = Q;
            while (curLevelTreeNode != null) {
                // 如果得到一个下一层的结点
                if (curLevelTreeNode.left != null) {
                    // 让下一层的前驱结点指向得到的下一层结点
                    if (nextLevelPreTreeNode != null) {
                        nextLevelPreTreeNode.next = curLevelTreeNode.left;
                    }
                    nextLevelPreTreeNode = curLevelTreeNode.left;
                    // 设置下一层的头
                    if (nextLevelHead == null) {
                        nextLevelHead = curLevelTreeNode.left;
                    }
                }
                // 如果得到一个下一层的结点
                if (curLevelTreeNode.right != null) {
                    // 让下一层的前驱结点指向得到的下一层结点
                    if (nextLevelPreTreeNode != null) {
                        nextLevelPreTreeNode.next = curLevelTreeNode.right;
                    }
                    nextLevelPreTreeNode = curLevelTreeNode.right;
                    // 设置下一层的头
                    if (nextLevelHead == null) {
                        nextLevelHead = curLevelTreeNode.right;
                    }
                }
                curLevelTreeNode = curLevelTreeNode.next;
            }
            Q = nextLevelHead;
        }
        return root;
    }
}
