/*

给定一个由n个整数组成的数组，找到给定长度k的连续子数组，该子数组具有最大平均值。你需要输出最大平均值。

样例

Example1

Input:  nums = [1,12,-5,-6,50,3] and k = 4
Output: 12.75
Explanation:
Maximum average is (12-5-6+50)/4 = 51/4 = 12.75


Example2
Input:  nums = [4,2,1,3,3] and k = 2
Output: 3.00
Explanation:
Maximum average is (3+3)/2 = 6/2 = 3.00


注意事项
1 <= k <= n <= 30,000.
给定数组的元素范围是[-10,000, 10,000]。
*/
// 测试平台： https://www.lintcode.com/problem/maximum-average-subarray/
package com.leetcode.tip09BinarySearch;
 class Solution868_2 {
  public double findMaxAverage(int[] A, int k) {
    final int N = A == null ? 0 : A.length;
    // 本质上就是滑动窗口
    double ans = 0;
    double s = 0;

    for (int i = 0; i < N; i++) {
      s += A[i];
      if (i < k - 1) {
        continue;
      }
      double tmp = s / (double)k;
      ans = Math.max(ans, tmp);

      // 当前区间为[i + 1 - k, i + 1)
      // 那么将要滑出窗口的元素为A[i + 1 - k]
      // 这个时需，需要从滑动窗口的和里面减去这个元素
      s -= A[i + 1 - k];
    }
    return ans;
  }
}
