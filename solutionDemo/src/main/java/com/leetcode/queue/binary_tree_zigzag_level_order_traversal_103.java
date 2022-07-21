package com.leetcode.queue;

import com.sun.xml.internal.bind.v2.TODO;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Author: linK
 * @Date: 2022/7/21 15:50
 * @Description TODO [103] 二叉树的锯齿形层序遍历
 * TODO 在层次遍历的时候，只需要利用一个boolean变量来指示是否要将当前遍历的结果进行reverse操作。
 * @lc app=leetcode.cn id=103 lang=java
 * <p>
 * [103] 二叉树的锯齿形层序遍历
 * <p>
 * https://leetcode-cn.com/problems/binary-tree-zigzag-level-order-traversal/description/
 * <p>
 * algorithms
 * Medium (57.10%)
 * Likes:    402
 * Dislikes: 0
 * Total Accepted:    117.5K
 * Total Submissions: 205.7K
 * Testcase Example:  '[3,9,20,null,null,15,7]'
 * <p>
 * 给定一个二叉树，返回其节点值的锯齿形层序遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
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
 * 返回锯齿形层序遍历如下：
 * <p>
 * <p>
 * [
 * ⁠ [3],
 * ⁠ [20,9],
 * ⁠ [15,7]
 * ]
 */
public class binary_tree_zigzag_level_order_traversal_103 {
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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        // 生成FIFO队列
        Queue<TreeNode> Q = new LinkedList<>();

        // 如果结点不为空，那么加入到FIFO队列
        if (root != null) {
            Q.offer(root);
        }

        // ans用于保存层次遍历的结果
        List<List<Integer>> ans = new LinkedList<>();
        boolean reverse = false;

        // 开始利用FIFO队列进行层次遍历
        while (Q.size() > 0) {
            // 取出当前层里面元素的个数
            final int qSize = Q.size();
            // 当前层的结果存放于tmp链表中
            List<Integer> tmp = new LinkedList<>();
            // 遍历当前层的每个结点
            for (int i = 0; i < qSize; i++) {
                // 当前层前面的结点先出队
                TreeNode cur = Q.poll();
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
            //TODO 反转指定列表中元素的顺序。
            if (reverse) {
                Collections.reverse(tmp);
            }
            // 把当前层的结果放到返回值里面。

            ans.add(tmp);
            // TODO 间隔一层反转
            reverse = !reverse;
        }
        return ans;
    }


}
