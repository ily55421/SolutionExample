package com.leetcode.tip06Tree;

/*
 * @lc app=leetcode.cn id=99 lang=java
 *
 * [99] 恢复二叉搜索树
 *
 * https://leetcode-cn.com/problems/recover-binary-search-tree/description/
 *
 * algorithms
 * Hard (62.07%)
 * Likes:    430
 * Dislikes: 0
 * Total Accepted:    50.5K
 * Total Submissions: 81.4K
 * Testcase Example:  '[1,3,null,null,2]'
 *
 * 给你二叉搜索树的根节点 root ，该树中的两个节点被错误地交换。请在不改变其结构的情况下，恢复这棵树。
 * 
 * 进阶：使用 O(n) 空间复杂度的解法很容易实现。你能想出一个只使用常数空间的解决方案吗？
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：root = [1,3,null,null,2]
 * 输出：[3,1,null,null,2]
 * 解释：3 不能是 1 左孩子，因为 3 > 1 。交换 1 和 3 使二叉搜索树有效。
 * 
 * 
 * 示例 2：
 * 
 * 
 * 输入：root = [3,1,4,null,null,2]
 * 输出：[2,1,4,null,null,3]
 * 解释：2 不能在 3 的右子树中，因为 2 < 3 。交换 2 和 3 使二叉搜索树有效。
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 树上节点的数目在范围 [2, 1000] 内
 * -2^31 
 * 
 * 
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
 * = left; this.right = right; } }
 */

// 这里尝试使用栈来求解

class Solution99_3 {
    // 第一个交换位置
    private TreeNode first = null;
    // 第二个交换位置
    private TreeNode second = null;

    // 记录中序遍历的前面的那个位置
    private TreeNode pre = null;

    // 检查是不是交换位置
    private void check(TreeNode cur) {
        // 如果原来的顺序是[1, 2, 3, 4, 5, 6, 7]
        // 两个节点交换之后[1, 6, 3, 4, 5, 2, 7]
        // 第一次是 6 > 3, 我们需要记住6
        if (pre != null && pre.val > cur.val) {
            if (first == null) {
                first = pre;
            }
            // 第二次是 5 > 2
            // 此时需要记住2
            second = cur;
        }
        // 记得更新pre
        pre = cur;
    }

    private void midOrder(TreeNode root) {
        // morris 遍历
        TreeNode cur = root;
        while (cur != null) {
            if (cur.left != null) {
                TreeNode pre = cur.left;
                while (pre.right != null && pre.right != cur) {
                    pre = pre.right;
                }

                if (pre.right == null) {
                    pre.right = cur;
                    cur = cur.left;
                } else {
                    check(cur);
                    pre.right = null;
                    cur = cur.right;
                }
            } else {
                check(cur);
                cur = cur.right;
            }
        }
    }

    public void recoverTree(TreeNode root) {
        first = second = pre = null;
        midOrder(root);
        if (first != null && second != null) {
            int t = first.val;
            first.val = second.val;
            second.val = t;
        }
    }
}
// @lc code=end
