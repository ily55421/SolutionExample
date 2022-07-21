package com.leetcode.queue;

import org.junit.Before;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.TreeMap;

/**
 * @Author: linK
 * @Date: 2022/7/21 15:24
 * @Description TODO [637] 二叉树的层平均值 这个题只需要在二叉树的层次遍历的基础上，将每一层的平均值求出来就可以了。
 * [637] 二叉树的层平均值 这个题只需要在二叉树的层次遍历的基础上，将每一层的平均值求出来就可以了。
 * <p>
 * https://leetcode-cn.com/problems/average-of-levels-in-binary-tree/description/
 * <p>
 * algorithms
 * Easy (68.78%)
 * Likes:    239
 * Dislikes: 0
 * Total Accepted:    56.4K
 * Total Submissions: 81.9K
 * Testcase Example:  '[3,9,20,15,7]'
 * <p>
 * 给定一个非空二叉树, 返回一个由每层节点平均值组成的数组。
 * <p>
 * 示例 1：
 * <p>
 * 输入：
 * ⁠   3
 * ⁠  / \
 * ⁠ 9  20
 * ⁠   /  \
 * ⁠  15   7
 * 输出：[3, 14.5, 11]
 * 解释：
 * 第 0 层的平均值是 3 ,  第1层是 14.5 , 第2层是 11 。因此返回 [3, 14.5, 11] 。
 * <p>
 * 提示：
 * 节点值的范围在32位有符号整数范围内。
 */
public class average_of_levels_in_binary_tree_637 {
    TreeNode root = null;

    /**
     * 节点初始化
     */
    @Before
    public void init ( ){
        root = new TreeNode(3);
        TreeNode level2Left = new TreeNode(9);
        TreeNode level2Right = new TreeNode(20);
        TreeNode level3Left = new TreeNode(15);
        TreeNode level3right = new TreeNode(7);
        root.left = level2Left;
        root.right = level2Right;
        level2Right.left = level3Left;
        level2Right.right = level3right;
    }
    @Test
    public void test() {
        List<Double> doubles = averageOfLevels(root);
        doubles.forEach(System.out::println);
        //3.0
        //14.5
        //11.0
    }

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode(int x) { val = x; }
     * }
     */
    public List<Double> averageOfLevels(TreeNode root) {
        // 生成FIFO队列
        Queue<TreeNode> Q = new LinkedList<>();
        // 如果结点不为空，那么加入到FIFO队列
        if (root != null) {
            Q.offer(root);
        }
        // ans用于保存层次遍历的结果
        List<Double> ans = new LinkedList<>();
        // 开始利用FIFO队列进行层次遍历
        while (Q.size() > 0) {
            // 取出当前层里面元素的个数
            final int qSize = Q.size();
            double tmp = 0;
            // 遍历当前层的每个结点
            for (int i = 0; i < qSize; i++) {
                // 当前层前面的结点先出队
                TreeNode cur = Q.poll();
                // 把结果累加到tmp中   累加然后求平均值
                tmp += cur.val;
                // 把下一层的结点入队，注意入队时需要非空才可以入队。
                if (cur.left != null) {
                    Q.offer(cur.left);
                }
                if (cur.right != null) {
                    Q.offer(cur.right);
                }
            }
            // 把当前层的结果放到返回值里面。  计算平均值
            tmp /= qSize;
            ans.add(tmp);
        }
        return ans;
    }
}
