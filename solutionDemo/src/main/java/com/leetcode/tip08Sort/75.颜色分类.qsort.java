/*
 * @lc app=leetcode.cn id=75 lang=java
 *
 * [75] 颜色分类
 *
 * https://leetcode-cn.com/problems/sort-colors/description/
 *
 * algorithms
 * Medium (57.26%)
 * Likes:    761
 * Dislikes: 0
 * Total Accepted:    166.8K
 * Total Submissions: 291.4K
 * Testcase Example:  '[2,0,2,1,1,0]'
 *
 * 给定一个包含红色、白色和蓝色，一共 n
 * 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 *
 * 此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
 *
 *
 *
 *
 *
 *
 * 示例 1：
 *
 *
 * 输入：nums = [2,0,2,1,1,0]
 * 输出：[0,0,1,1,2,2]
 *
 *
 * 示例 2：
 *
 *
 * 输入：nums = [2,0,1]
 * 输出：[0,1,2]
 *
 *
 * 示例 3：
 *
 *
 * 输入：nums = [0]
 * 输出：[0]
 *
 *
 * 示例 4：
 *
 *
 * 输入：nums = [1]
 * 输出：[1]
 *
 *
 *
 *
 * 提示：
 *
 *
 * n == nums.length
 * 1
 * nums[i] 为 0、1 或 2
 *
 *
 *
 *
 * 进阶：
 *
 *
 * 你可以不使用代码库中的排序函数来解决这道题吗？
 * 你能想出一个仅使用常数空间的一趟扫描算法吗？
 *
 *
 */
package com.leetcode.tip08Sort;
// @lc code=start
class Solution75q {
  private void swap(int[] A, int i, int j) {
    int t = A[i];
    A[i] = A[j];
    A[j] = t;
  }
  private void qsort(int[] A, int b, int e) {
    if (b >= e || b + 1 >= e) {
      return;
    }

    final int m = b + ((e - b) >> 1);
    final int x = A[m];

    int l = b, i = b, r = e - 1;

    while (i <= r) {
      if (A[i] < x) {
        swap(A, l++, i++);
      } else if (A[i] == x) {
        i++;
      } else {
        swap(A, r--, i);
      }
    }

    qsort(A, b, l);
    qsort(A, i, e);
  }
  public void sortColors(int[] nums) {
    if (nums == null)
      return;
    qsort(nums, 0, nums.length);
  }
}
// @lc code=end
