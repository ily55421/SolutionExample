package com.leetcode.queue;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Author: linK
 * @Date: 2022/7/21 15:38
 * @Description TODO [429] N 叉树的层序遍历 在层次遍历的基础上，这里只是将left, right两个左右子结点改成了children。
 * @lc app=leetcode.cn id=429 lang=java
 * <p>
 * [429] N 叉树的层序遍历
 * <p>
 * https://leetcode-cn.com/problems/n-ary-tree-level-order-traversal/description/
 * <p>
 * algorithms
 * Medium (68.07%)
 * Likes:    135
 * Dislikes: 0
 * Total Accepted:    40.1K
 * Total Submissions: 58.8K
 * Testcase Example:  '[1,null,3,2,4,null,5,6]'
 * <p>
 * 给定一个 N 叉树，返回其节点值的层序遍历。（即从左到右，逐层遍历）。
 * <p>
 * 树的序列化输入是用层序遍历，每组子节点都由 null 值分隔（参见示例）。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * <p>
 * 输入：root = [1,null,3,2,4,null,5,6]
 * 输出：[[1],[3,2,4],[5,6]]
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * <p>
 * <p>
 * 输入：root =
 * [1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,null,13,null,null,14]
 * 输出：[[1],[2,3,4,5],[6,7,8,9,10],[11,12,13],[14]]
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 树的高度不会超过 1000
 * 树的节点总数在 [0, 10^4] 之间
 */
public class n_ary_tree_level_order_traversal_429 {
    // @lc code=start
    /*
    // Definition for a Node.
    class Node {
        public int val;
        public List<Node> children;
        public Node() {}
        public Node(int _val) {
            val = _val;
        }
        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    };
    */
    public List<List<Integer>> levelOrder(Node root) {
        // 生成FIFO队列
        Queue<Node> Q = new LinkedList<>();
        // 如果结点不为空，那么加入到FIFO队列
        if (root != null) {
            Q.offer(root);
        }

        // ans用于保存层次遍历的结果
        List<List<Integer>> ans = new LinkedList<>();
        // TODO 开始利用FIFO队列进行层次遍历
        while (Q.size() > 0) {
            // 取出当前层里面元素的个数
            final int qSize = Q.size();
            // 当前层的结果存放于tmp链表中
            List<Integer> tmp = new LinkedList<>();
            // 遍历当前层的每个结点
            for (int i = 0; i < qSize; i++) {
                // 当前层前面的结点先出队
                Node cur = Q.poll();
                // 把结果存放当于当前层中
                tmp.add(cur.val);
                // 把下一层的结点入队，注意入队时需要非空才可以入队。  遍历所有子节点
                for (Node t : cur.children) {
                    if (t != null) {
                        Q.add(t);
                    }
                }
            }
            // 把当前层的结果放到返回值里面。
            ans.add(tmp);
        }
        return ans;
    }
}

/**
 * 节点结构
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