package com.leetcode.tip06Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution144s {
    public List<Integer> preorderTraversal(TreeNode root) {
        Stack<TreeNode> s = new Stack<>();
        List<Integer> ans = new ArrayList<>();
        while (root != null || !s.empty()) {
            while (root != null) {
                ans.add(root.val);
                s.push(root);
                root = root.left;
            }
            root = s.peek();
            s.pop();
            root = root.right;
        }
        return ans;
    }
}
