package com.leetcode.tip00.queue;

import java.util.ArrayDeque;

/**
 * @Author: linK
 * @Date: 2022/7/21 17:10
 * @Description TODO [1696] 跳跃游戏 VI 有的时候，滑动窗口不一定是在给定的数组上操作，还可能会在一个隐藏的数组上操作。
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
public class jump_game_vi_1696 {
    public int maxResult(int[] A, int k) {
        // 处理掉各种边界条件!
        if (A == null || A.length == 0 || k <= 0) {
            return 0;
        }

        final int N = A.length;
        // 每个位置可以收集到的金币数目
        int[] get = new int[N];

        // 单调队列，这里并不是严格递减
        ArrayDeque<Integer> Q = new ArrayDeque<Integer>();

        for (int i = 0; i < N; i++) {
            // 在取最大值之前，需要保证单调队列中都是有效值。
            // 也就是都在区间里面的值
            // 当要求get[i]的时候，
            // 单调队列中应该是只能保存
            if (i - k > 0) {
                if (!Q.isEmpty() && Q.getFirst() == get[i - k - 1]) {
                    Q.removeFirst();
                }
            }

            // 从单调队列中取得较大值
            int old = Q.isEmpty() ? 0 : Q.getFirst();
            get[i] = old + A[i];

            // 入队的时候，采用单调队列入队
            while (!Q.isEmpty() && Q.getLast() < get[i]) {
                Q.removeLast();
            }
            Q.addLast(get[i]);
        }

        return get[N - 1];
    }
}
