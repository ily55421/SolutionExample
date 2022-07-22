package com.leetcode.tip06Tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution144 {
    private void preOrder(TreeNode root, List<Integer> ans) {
        if (root != null) {
            ans.add(root.val);
            preOrder(root.left, ans);
            preOrder(root.right, ans);
        }
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        preOrder(root, ans);
        return ans;
    }
}
