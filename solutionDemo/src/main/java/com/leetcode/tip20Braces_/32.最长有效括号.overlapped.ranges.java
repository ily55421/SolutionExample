package com.leetcode.tip20Braces_;/*
 * @lc app=leetcode.cn id=32 lang=java
 *
 * [32] 最长有效括号
 *
 * https://leetcode-cn.com/problems/longest-valid-parentheses/description/
 *
 * algorithms
 * Hard (34.80%)
 * Likes:    1283
 * Dislikes: 0
 * Total Accepted:    145.9K
 * Total Submissions: 419.1K
 * Testcase Example:  '"(()"'
 *
 * 给你一个只包含 '(' 和
 * ')' 的字符串，找出最长有效（格式正确且连续）括号子串的长度。
 *
 *
 *
 *
 *
 * 示例 1：
 *
 *
 * 输入：s = "(()"
 * 输出：2
 * 解释：最长有效括号子串是 "()"
 *
 *
 * 示例 2：
 *
 *
 * 输入：s = ")()())"
 * 输出：4
 * 解释：最长有效括号子串是 "()()"
 *
 *
 * 示例 3：
 *
 *
 * 输入：s = ""
 * 输出：0
 *
 *
 *
 *
 * 提示：
 *
 *
 * 0
 * s[i] 为 '(' 或 ')'
 *
 *
 *
 *
 */

import java.util.*;

// @lc code=start
class Solution32OverRang
{
  public int longestValidParentheses(String s)
  {
    // 采用相每重叠的最长的区间的做法
    final int N = s == null ? 0 : s.length();

    // 两两配对的时候，我们将它们看成一个区间
    // 配对的时候，需要用到栈
    Stack<Integer> st = new Stack<>();

    List<int[]> ranges = new ArrayList<>();

    for (int i = 0; i < N; i++) {
      final char c = s.charAt(i);

      if (c == ')') {
        if (!st.isEmpty()) {
          final int topIdx = st.pop();
          ranges.add(new int[] { topIdx, i });
        }
      } else {
        st.push(i);
      }
    }

    Collections.sort(ranges, new Comparator<int[]>() {
      public int compare(int[] a, int[] b) { return a[0] - b[0]; }
    });

    // 由于得到了很多区间，我们需要取相互覆盖的区间的最长值
    // 比如，我们认为[3,4], [5,6]是相互连续且覆盖的区间
    int start = 0;
    int end = -1;
    int ans = 0;

    for (int i = 0; i < ranges.size(); i++) {
      final int from = ranges.get(i)[0], to = ranges.get(i)[1];

      // 如果和[start, end]这个区间相交
      if (from <= end + 1) {
        end = Math.max(end, to);
      } else {
        // 如果不相交!
        start = from;
        end = to;
      }

      ans = Math.max(ans, end - start + 1);
    }

    return ans;
  }
}
// @lc code=end

/*
public class Main
{
  public static void main(String[] args)
  {
    String s = "()(())";
    Solution32OR t = new Solution32OR();
    System.out.println(t.longestValidParentheses(s));
  }
}*/
