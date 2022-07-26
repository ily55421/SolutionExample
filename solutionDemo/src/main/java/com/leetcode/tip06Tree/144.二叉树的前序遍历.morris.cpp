/*
 *
 * [144] 二叉树的前序遍历
 *
 * https://leetcode-cn.com/problems/binary-tree-preorder-traversal/description/
 * https://www.lintcode.com/problem/binary-tree-preorder-traversal/
 *
 * algorithms
 * Medium (66.89%)
 * Likes:    367
 * Dislikes: 0
 * Total Accepted:    170.7K
 * Total Submissions: 255.3K
 * Testcase Example:  '[1,null,2,3]'
 *
 * 给定一个二叉树，返回它的 前序 遍历。
 *
 * 示例:
 *
 * 输入: [1,null,2,3]
 * ⁠  1
 * ⁠   \
 * ⁠    2
 * ⁠   /
 * ⁠  3
 *
 * 输出: [1,2,3]
 *
 *
 * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 *
 */

/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */

class Solution {
   public:
    vector<int> preorderTraversal(TreeNode* root) {
        vector<int> ans;
        auto cur = root;
        while (cur) {
            if (cur->left) {
                auto pre = cur->left;
                while (pre->right && pre->right != cur) {
                    pre = pre->right;
                }

                if (!pre->right) {
                    ans.push_back(cur->val);
                    pre->right = cur;
                    cur = cur->left;
                } else {
                    pre->right = nullptr;
                    cur = cur->right;
                }
            } else {
                ans.push_back(cur->val);
                cur = cur->right;
            }
        }

        return ans;
    }
};

