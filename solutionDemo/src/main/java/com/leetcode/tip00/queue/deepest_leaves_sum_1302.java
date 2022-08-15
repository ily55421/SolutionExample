package com.leetcode.tip00.queue;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author: linK
 * @Date: 2022/7/21 15:43
 * @Description TODO [1302] 层数最深叶子节点的和 这里只需要处理最后一层，然后将其和返回就可以了。
 * @lc app=leetcode.cn id=1302 lang=java
 * <p>
 * [1302] 层数最深叶子节点的和
 * <p>
 * https://leetcode-cn.com/problems/deepest-leaves-sum/description/
 * <p>
 * algorithms
 * Medium (81.31%)
 * Likes:    47
 * Dislikes: 0
 * Total Accepted:    14.2K
 * Total Submissions: 17.4K
 * Testcase Example:  '[1,2,3,4,5,null,6,7,null,null,null,null,8]'
 * <p>
 * 给你一棵二叉树，请你返回层数最深的叶子节点的和。
 * <p>
 * <p>
 * <p>
 * 示例：
 * <p>
 * <p>
 * <p>
 * 输入：root = [1,2,3,4,5,null,6,7,null,null,null,null,8]
 * 输出：15
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 树中节点数目在 1 到 10^4 之间。
 * 每个节点的值在 1 到 100 之间。
 */
public class deepest_leaves_sum_1302 {
    // @lc code=start

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode(int x) { val = x; }
     * }
     */
    public int deepestLeavesSum(TreeNode root) {
        // 生成FIFO队列
        Queue<TreeNode> Q = new LinkedList<>();
        // 如果结点不为空，那么加入到FIFO队列
        if (root != null) {
            Q.offer(root);
        }
        // ans用于保存结果
        int ans = 0;
        // TODO 开始利用FIFO队列进行层次遍历  每一层级将结果清零 只到最后一层
        //  如果不清零就是所有和的累加
        while (Q.size() > 0) {
            // 取出当前层里面元素的个数
            final int qSize = Q.size();
            // 当前层的和存放在tmp里面。
            int tmp = 0;
            // 遍历当前层的每个结点
            for (int i = 0; i < qSize; i++) {
                // 当前层前面的结点先出队
                TreeNode cur = Q.poll();
                // 把结果存放当于当前层中
                tmp += cur.val;
                // 把下一层的结点入队，注意入队时需要非空才可以入队。
                if (cur.left != null) {
                    Q.offer(cur.left);
                }
                if (cur.right != null) {
                    Q.offer(cur.right);
                }
            }
            // 把当前层的结果放到返回值里面。
            ans = tmp;
        }
        return ans;
    }
}
