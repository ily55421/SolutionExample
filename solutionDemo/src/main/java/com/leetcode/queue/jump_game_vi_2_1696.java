package com.leetcode.queue;

import java.util.ArrayDeque;

/**
 * @Author: linK
 * @Date: 2022/7/21 17:10
 * @Description TODO [1696] 跳跃游戏 VI  第二种解解法
 * TODO 每个学科都会涉及很多知识，靠做题记知识点，就容易出现知识之间的割裂而形成孤立地，无法将知识系统化。
 * TODO 希望你在做题的过程中能够主动尝试建立知识之间的联系，主动思考如何让新知识与原有知识相关联，提高学习效率。
 * TODO 比如，循环队列实际上也是单调队列的好帮手，当然你也可以用来实现 FIFO 队列。
 * <p>
 *    todo 整理出模板：
 *     分层遍历
 *     循环队列
 *     单调队列
 * </p>
 * [1696] 跳跃游戏 VI
 * <p>
 * https://leetcode-cn.com/problems/jump-game-vi/description/
 * <p>
 * algorithms
 * Medium (33.27%)
 * Likes:    18
 * Dislikes: 0
 * Total Accepted:    2.5K
 * Total Submissions: 7.4K
 * Testcase Example:  '[1,-1,-2,4,-7,3]\n2'
 * <p>
 * 给你一个下标从 0 开始的整数数组 nums 和一个整数 k 。
 * <p>
 * 一开始你在下标 0 处。每一步，你最多可以往前跳 k 步，但你不能跳出数组的边界。也就是说，你可以从下标 i 跳到 [i + 1， min(n - 1,
 * i + k)] 包含 两个端点的任意位置。
 * <p>
 * 你的目标是到达数组最后一个位置（下标为 n - 1 ），你的 得分 为经过的所有数字之和。
 * <p>
 * 请你返回你能得到的 最大得分 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：nums = [1,-1,-2,4,-7,3], k = 2
 * 输出：7
 * 解释：你可以选择子序列 [1,-1,4,3] （上面加粗的数字），和为 7 。
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：nums = [10,-5,-2,4,0,3], k = 3
 * 输出：17
 * 解释：你可以选择子序列 [10,4,3] （上面加粗数字），和为 17 。
 * <p>
 * <p>
 * 示例 3：
 * <p>
 * <p>
 * 输入：nums = [1,-5,-20,4,-1,3,-6,-3], k = 2
 * 输出：0
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1
 * -10^4
 */
public class jump_game_vi_2_1696 {
    class Solution {
        // 走到下标index = idx的记录
        class Node {
            // 累计取得的金币!
            int sum = 0;
            // 在index = idx的时候
            // 取得的最大金币为sum
            int idx = 0;

            public Node(int s, int i) {
                sum = s;
                idx = i;
            }
        }

        public int maxResult(int[] A, int k) {
            // 严格单调递减队列
            // 里面存放的是每个位置可以收集到的金币以及下标index
            ArrayDeque<Node> Q = new ArrayDeque<Node>();

            // 走到i位置时，最大的金币收益
            int ans = 0;

            for (int i = 0; i < A.length; i++) {
                // 出队！
                // 对于i而言，
                // [i-k, i-1]可以跳到A[i]
                // 最远i - (i - k) = k
                // 因此超出这个范围的，必须要出队
                while (!Q.isEmpty() && i - Q.getFirst().idx > k) {
                    Q.removeFirst();
                }

                // 获得在位置i时的收益
                if (Q.isEmpty()) {
                    ans = A[i];
                } else {
                    ans = Q.getFirst().sum + A[i];
                }

                // 入队，当A[i]入队的时候，要把小于他的那些
                // 收益比他低，又比他旧的给踢除掉
                // 注意！这里使用的是严格的单调递减!
                while (!Q.isEmpty() && Q.getLast().sum <= ans) {
                    Q.removeLast();
                }

                Q.addLast(new Node(ans, i));
            }

            return ans;
        }
    }
}