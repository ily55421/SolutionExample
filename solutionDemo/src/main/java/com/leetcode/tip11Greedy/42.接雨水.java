/*
 * @lc app=leetcode.cn id=42 lang=java
 *
 * [42] 接雨水
 *
 * https://leetcode-cn.com/problems/trapping-rain-water/description/
 *
 * algorithms
 * Hard (54.56%)
 * Likes:    2115
 * Dislikes: 0
 * Total Accepted:    205K
 * Total Submissions: 375.4K
 * Testcase Example:  '[0,1,0,2,1,0,1,3,2,1,2,1]'
 *
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 
 * 
 * 输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出：6
 * 解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。 
 * 
 * 
 * 示例 2：
 * 
 * 
 * 输入：height = [4,2,0,3,2,5]
 * 输出：9
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * n == height.length
 * 0 
 * 0 
 * 
 * 
 */
package com.leetcode.tip11Greedy;



// @lc code=start
class Solution42 {
   /*
    def trap(self, height: List[int]) -> int:
    ans = 0
    h1 = 0
    h2 = 0
            for i in range(len(height)):
    h1 = max(h1,height[i])
    h2 = max(h2,height[-i-1])
    ans = ans + h1 + h2 -height[i]
            return  ans - len(height)*h1
    */

    public int trap(int[] height) {
            int ans = 0;
            int h1 = 0;
            int h2 = 0;
        for (int i = 0; i < height.length; i++) {
            //
            h1 = Math.max(h1, height[i]);
            // 这里会抛出下标越界异常
            h2 = Math.max(h2, height[-i - 1]);
            ans += h1 + h2 - height[i];
        }
        return ans - height.length * h1;
    }
}
// @lc code=end

