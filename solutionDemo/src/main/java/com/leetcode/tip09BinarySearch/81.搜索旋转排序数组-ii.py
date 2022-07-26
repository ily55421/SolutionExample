#
# @lc app=leetcode.cn id=81 lang=python
#
# [81] 搜索旋转排序数组 II
#
# https://leetcode-cn.com/problems/search-in-rotated-sorted-array-ii/description/
#
# algorithms
# Medium (36.74%)
# Likes:    283
# Dislikes: 0
# Total Accepted:    52.9K
# Total Submissions: 143.9K
# Testcase Example:  '[2,5,6,0,0,1,2]\n0'
#
# 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
# 
# ( 例如，数组 [0,0,1,2,2,5,6] 可能变为 [2,5,6,0,0,1,2] )。
# 
# 编写一个函数来判断给定的目标值是否存在于数组中。若存在返回 true，否则返回 false。
# 
# 示例 1:
# 
# 输入: nums = [2,5,6,0,0,1,2], target = 0
# 输出: true
# 
# 
# 示例 2:
# 
# 输入: nums = [2,5,6,0,0,1,2], target = 3
# 输出: false
# 
# 进阶:
# 
# 
# 这是 搜索旋转排序数组 的延伸题目，本题中的 nums  可能包含重复元素。
# 这会影响到程序的时间复杂度吗？会有怎样的影响，为什么？
# 
# 
#

# @lc code=start
class com.leetcode.tip22DS_.Solution(object):
    def search(self, A, x):
        N = len(A) if A else 0
        l = 0
        r = N

        while l < r:
            m = l + ((r-l)>>1)

            if A[l] == x or A[m] == x or A[r-1] == x:
                return True
            if A[l] == A[m]:
                l += 1
                continue

            if A[m] > A[l]:
                if A[l] < x and x < A[m]:
                    r = m
                else:
                    l = m + 1
            else:
                if A[m] < x and x < A[r-1]:
                    l = m + 1
                else:
                    r = m
        return False
# @lc code=end

