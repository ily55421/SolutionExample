package com.leetcode.tip12BackTrack;

import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=17 lang=java
 *
 * [17] 电话号码的字母组合
 *
 * https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/description/
 *
 * algorithms
 * Medium (56.04%)
 * Likes:    1190
 * Dislikes: 0
 * Total Accepted:    237K
 * Total Submissions: 422K
 * Testcase Example:  '"23"'
 *
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
 * 
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 * 
 * 
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：digits = "23"
 * 输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
 * 
 * 
 * 示例 2：
 * 
 * 
 * 输入：digits = ""
 * 输出：[]
 * 
 * 
 * 示例 3：
 * 
 * 
 * 输入：digits = "2"
 * 输出：["a","b","c"]
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 0 
 * digits[i] 是范围 ['2', '9'] 的一个数字。
 * 
 * 
 */

// @lc code=start
class Solution17 {
    final String[] ds = new String[] { //
            "", // 0
            "", // 1
            "abc", // 2
            "def", // 3
            "ghi", // 4
            "jkl", // 5
            "mno", // 6
            "pqrs", // 7
            "tuv", // 8
            "wxyz" // 9
    };

    void backtrack(String A, int i, StringBuffer box, List<String> ans) {
        final int N = A == null ? 0 : A.length();

        // 如果我们发现状态满足要求
        if (box.length() == N) {
            ans.add(box.toString());
        }

        // 如果发现越界, 第N个人开始就没有宝石选项了
        if (i >= N) {
            return;
        }

        // 遍历第i个人可以选择的宝石
        final int stoneIndex = (int) (A.charAt(i) - '0');
        for (int idx = 0; idx < ds[stoneIndex].length(); idx++) {
            // 拿到宝石
            Character stone = ds[stoneIndex].charAt(idx);
            // 放到箱子中
            box.append(stone);

            // 开始处理第i + 1个人
            backtrack(A, i + 1, box, ans);

            // 把自己的宝石拿出来，然后保持箱子原样!
            box.deleteCharAt(box.length() - 1);
        }

    }

    public List<String> letterCombinations(String A) {
        if (A == null || A.length() == 0) {
            return new ArrayList<>();
        }
        StringBuffer box = new StringBuffer();
        List<String> ans = new ArrayList<>();

        backtrack(A, 0/* 从第0个人开始 */, box, ans);

        return ans;
    }
}
// @lc code=end
