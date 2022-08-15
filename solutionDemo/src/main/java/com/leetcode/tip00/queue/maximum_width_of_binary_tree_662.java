package com.leetcode.tip00.queue;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author: linK
 * @Date: 2022/7/21 15:47
 * @Description TODO  [662] 二叉树最大宽度
 * todo 这里采用了分层遍历的思想来拿到最大宽度。
 * TODO 需要在入栈的时候，对结点进行编号。在编号的时候，如果父结点编号为x
 * todo 左子结点为 2 * x
 * todo 右子结点为 2 * x + 1
 * todo 然后这个编号需要和结点一起入队。
 * @lc app=leetcode.cn id=662 lang=java
 * <p>
 * [662] 二叉树最大宽度
 * <p>
 * https://leetcode-cn.com/problems/maximum-width-of-binary-tree/description/
 * <p>
 * algorithms
 * Medium (39.16%)
 * Likes:    203
 * Dislikes: 0
 * Total Accepted:    16.2K
 * Total Submissions: 41.5K
 * Testcase Example:  '[1,3,2,5,3,null,9]'
 * <p>
 * 给定一个二叉树，编写一个函数来获取这个树的最大宽度。树的宽度是所有层中的最大宽度。这个二叉树与满二叉树（full binary
 * tree）结构相同，但一些节点为空。
 * <p>
 * 每一层的宽度被定义为两个端点（该层最左和最右的非空节点，两端点间的null节点也计入长度）之间的长度。
 * <p>
 * 示例 1:
 * <p>
 * <p>
 * 输入:
 * <p>
 * ⁠          1
 * ⁠        /   \
 * ⁠       3     2
 * ⁠      / \     \
 * ⁠     5   3     9
 * <p>
 * 输出: 4
 * 解释: 最大值出现在树的第 3 层，宽度为 4 (5,3,null,9)。
 * <p>
 * <p>
 * 示例 2:
 * <p>
 * <p>
 * 输入:
 * <p>
 * ⁠         1
 * ⁠        /
 * ⁠       3
 * ⁠      / \
 * ⁠     5   3
 * <p>
 * 输出: 2
 * 解释: 最大值出现在树的第 3 层，宽度为 2 (5,3)。
 * <p>
 * <p>
 * 示例 3:
 * <p>
 * <p>
 * 输入:
 * <p>
 * ⁠         1
 * ⁠        / \
 * ⁠       3   2
 * ⁠      /
 * ⁠     5
 * <p>
 * 输出: 2
 * 解释: 最大值出现在树的第 2 层，宽度为 2 (3,2)。
 * <p>
 * <p>
 * 示例 4:
 * <p>
 * <p>
 * 输入:
 * <p>
 * ⁠         1
 * ⁠        / \
 * ⁠       3   2
 * ⁠      /     \
 * ⁠     5       9
 * ⁠    /         \
 * ⁠   6           7
 * 输出: 8
 * 解释: 最大值出现在树的第 4 层，宽度为 8 (6,null,null,null,null,null,null,7)。
 * <p>
 * <p>
 * 注意: 答案在32位有符号整数的表示范围内。
 */
public class maximum_width_of_binary_tree_662 {
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

    class Pair {
        private TreeNode node;
        private int id;

        public Pair(TreeNode n, int i) {
            node = n;
            id = i;
        }
    }

    public int widthOfBinaryTree(TreeNode root) {
        // 生成FIFO队列
        Queue<Pair> Q = new LinkedList<>();

        // 如果结点不为空，那么加入到FIFO队列
        if (root != null) {
            Q.offer(new Pair(root, 0));
        }

        int ans = 0;

        // 开始利用FIFO队列进行层次遍历
        while (Q.size() > 0) {
            // 取出当前层里面元素的个数
            final int qSize = Q.size();
            int start = -1;
            int end = -1;
            // 这里要在当前层中找到[start, end]
            // 在这个区间之外的都是null
            // 这些null的子结点是不能入队的。
            // 但是在[start, end]这个范围里面的null
            // 是可以入队的。
            for (int i = 0; i < qSize; i++) {
                // 当前层前面的结点先出队
                Pair cur = Q.poll();
                if (-1 == start) {
                    start = cur.id;
                }
                end = cur.id;
                if (cur.node.left != null) {
                    Q.offer(new Pair(cur.node.left, cur.id << 1));
                }
                if (cur.node.right != null) {
                    Q.offer(new Pair(cur.node.right, (cur.id << 1) + 1));
                }
            }
            ans = Math.max(ans, end - start + 1);
        }

        return ans;
    }


}
