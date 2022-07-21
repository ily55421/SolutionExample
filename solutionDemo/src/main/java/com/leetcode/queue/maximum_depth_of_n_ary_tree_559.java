package com.leetcode.queue;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Author: linK
 * @Date: 2022/7/21 15:58
 * @Description TODO   [559] N 叉树的最大深度 和二叉树的最大深度一样来处理。
 * @lc app=leetcode.cn id=559 lang=java
 * <p>
 * [559] N 叉树的最大深度
 * <p>
 * https://leetcode-cn.com/problems/maximum-depth-of-n-ary-tree/description/
 * <p>
 * algorithms
 * Easy (71.45%)
 * Likes:    152
 * Dislikes: 0
 * Total Accepted:    43.7K
 * Total Submissions: 61.2K
 * Testcase Example:  '[1,null,3,2,4,null,5,6]'
 * <p>
 * 给定一个 N 叉树，找到其最大深度。
 * <p>
 * 最大深度是指从根节点到最远叶子节点的最长路径上的节点总数。
 * <p>
 * N 叉树输入按层序遍历序列化表示，每组子节点由空值分隔（请参见示例）。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * <p>
 * 输入：root = [1,null,3,2,4,null,5,6]
 * 输出：3
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * <p>
 * <p>
 * 输入：root =
 * [1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,null,13,null,null,14]
 * 输出：5
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 树的深度不会超过 1000 。
 * 树的节点数目位于 [0, 10^4] 之间。
 */
public class maximum_depth_of_n_ary_tree_559 {
    // @lc code=start

    /**
     * // Definition for a Node.
     * class Node {
     * public int val;
     * public List<Node> children;
     * public Node() {}
     * public Node(int _val) {
     * val = _val;
     * }
     * public Node(int _val, List<Node> _children) {
     * val = _val;
     * children = _children;
     * }
     * };
     */
    class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    public int maxDepth(Node root) {
        // 生成FIFO队列
        Queue<Node> Q = new LinkedList<>();
        // 如果结点不为空，那么加入到FIFO队列
        if (root != null) {
            Q.offer(root);
        }
        // 层次高度
        int depth = 0;
        // 开始利用FIFO队列进行层次遍历
        while (Q.size() > 0) {
            // 取出当前层里面元素的个数
            final int qSize = Q.size();
            // 遍历当前层的每个结点
            for (int i = 0; i < qSize; i++) {
                // 当前层前面的结点先出队
                Node cur = Q.poll();
                // 把下一层的结点入队，注意入队时需要非空才可以入队。
                for (Node t : cur.children) {
                    if (t != null) {
                        Q.add(t);
                    }
                }
            }
            // TODO 每一层次 累加
            depth++;
        }
        return depth;
    }

}
