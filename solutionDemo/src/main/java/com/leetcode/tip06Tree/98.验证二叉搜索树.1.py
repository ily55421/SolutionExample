#
#
# [98] 验证二叉搜索树
#
# https://leetcode-cn.com/problems/validate-binary-search-tree/description/
# https://www.lintcode.com/problem/validate-binary-search-tree/
#
# algorithms
# Medium (33.13%)
# Likes:    876
# Dislikes: 0
# Total Accepted:    205.7K
# Total Submissions: 621.1K
# Testcase Example:  '[2,1,3]'
#
# 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
# 
# 假设一个二叉搜索树具有如下特征：
# 
# 
# 节点的左子树只包含小于当前节点的数。
# 节点的右子树只包含大于当前节点的数。
# 所有左子树和右子树自身必须也是二叉搜索树。
# 
# 
# 示例 1:
# 
# 输入:
# ⁠   2
# ⁠  / \
# ⁠ 1   3
# 输出: true
# 
# 
# 示例 2:
# 
# 输入:
# ⁠   5
# ⁠  / \
# ⁠ 1   4
# / \
# 3   6
# 输出: false
# 解释: 输入为: [5,1,4,null,null,3,6]。
# 根节点的值为 5 ，但是其右子节点值为 4 。
# 
# 
#

# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class com.leetcode.tip22DS_.Solution(object):
    def __init__(self):
        self.ans = True

    def preOrder(self, root, l, r):
        if not root or not self.ans:
            return
        
        if not (l < root.val and root.val < r):
            self.ans = False
            return

        self.preOrder(root.left, l, root.val)
        self.preOrder(root.right, root.val, r)

    def isValidBST(self, root):
        """
        :type root: TreeNode
        :rtype: bool
        """
        self.ans = True
        self.preOrder(root, float('-inf'), float('inf'))
        return self.ans


