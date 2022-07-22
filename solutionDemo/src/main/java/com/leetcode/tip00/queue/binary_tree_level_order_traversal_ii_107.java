package com.leetcode.tip00.queue;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Author: linK
 * @Date: 2022/7/21 15:55
 * @Description TODO [107] 二叉树的层序遍历 II 只需要遍历完成之后，将最后的结果reverse一下就可以了。
 * @lc app=leetcode.cn id=107 lang=java
 * <p>
 * [107] 二叉树的层序遍历 II
 * <p>
 * https://leetcode-cn.com/problems/binary-tree-level-order-traversal-ii/description/
 * <p>
 * algorithms
 * Medium (68.19%)
 * Likes:    412
 * Dislikes: 0
 * Total Accepted:    126.6K
 * Total Submissions: 185.7K
 * Testcase Example:  '[3,9,20,null,null,15,7]'
 * <p>
 * 给定一个二叉树，返回其节点值自底向上的层序遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
 * <p>
 * 例如：
 * 给定二叉树 [3,9,20,null,null,15,7],
 * <p>
 * <p>
 * ⁠   3
 * ⁠  / \
 * ⁠ 9  20
 * ⁠   /  \
 * ⁠  15   7
 * <p>
 * <p>
 * 返回其自底向上的层序遍历为：
 * <p>
 * <p>
 * [
 * ⁠ [15,7],
 * ⁠ [9,20],
 * ⁠ [3]
 * ]
 */
public class binary_tree_level_order_traversal_ii_107 {
    // @lc code=start

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode() {}
     * TreeNode(int val) { this.val = val; }
     * TreeNode(int val, TreeNode left, TreeNode right) {
     * this.val = val;
     * this.left = left;
     * this.right = right;
     * }
     * }
     */
    public List<List<Integer>> levelOrderBottom(com.leetcode.queue.TreeNode root) {
        // 生成FIFO队列
        Queue<com.leetcode.queue.TreeNode> Q = new LinkedList<>();
        // 如果结点不为空，那么加入到FIFO队列
        if (root != null) {
            Q.offer(root);
        }
        // ans用于保存层次遍历的结果
        List<List<Integer>> ans = new LinkedList<>();
        // 开始利用FIFO队列进行层次遍历
        while (Q.size() > 0) {
            // 取出当前层里面元素的个数
            final int qSize = Q.size();
            // 当前层的结果存放于tmp链表中
            List<Integer> tmp = new LinkedList<>();
            // 遍历当前层的每个结点
            for (int i = 0; i < qSize; i++) {
                // 当前层前面的结点先出队
                com.leetcode.queue.TreeNode cur = Q.poll();
                // 把结果存放当于当前层中
                tmp.add(cur.val);
                // 把下一层的结点入队，注意入队时需要非空才可以入队。
                if (cur.left != null) {
                    Q.offer(cur.left);
                }
                if (cur.right != null) {
                    Q.offer(cur.right);
                }
            }
            // 把当前层的结果放到返回值里面。
            ans.add(tmp);
        }
        // TODO 反转所有结果集
        Collections.reverse(ans);
        return ans;
    }
}
