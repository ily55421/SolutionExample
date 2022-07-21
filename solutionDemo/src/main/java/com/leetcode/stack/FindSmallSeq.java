package com.leetcode.stack;

import org.junit.Test;

import java.util.Stack;

/**
 * @Author: linK
 * @Date: 2022/7/21 14:12
 * @Description TODO 例 4：字典序最小的 k 个数的子序列
 * <p>
 * 【题目】给定一个正整数数组和 k，要求依次取出 k 个数，输出其中数组的一个子序列，
 * 需要满足：1. 长度为 k；2.字典序最小。
 * 输入：nums = [3,5,2,6], k = 2
 * 输出：[2,6]
 * 解释：在所有可能的解：{[3,5], [3,2], [3,6], [5,2], [5,6], [2,6]} 中，[2,6] 字典序最小。
 * TODO 从简单栈到单调栈，层层推进的过程中，不停变化就是入栈与出栈的时机。
 * </p>
 * <p>
 *     这个题目的考点也就非常明了了：
 *     递增栈
 *     个数控制，我们只需要取 k 个数出来。
 * </p>
 */
public class FindSmallSeq {
    @Test
    public void test() {
        int[] arr = {9, 2, 4, 5, 1, 2, 3, 0};
        int k = 3;
        for (int i : findSmallSeq(arr, k)) {
            System.out.println(i);
            //1
            //2
            //0
        }
    }

    @Test
    public void test1() {
        int[] arr = {9, 2, 4, 5, 1, 2, 3, 10};
        int k = 3;
        for (int i : findSmallSeq(arr, k)) {
            System.out.println(i);
            //1
            //2
            //3
        }
    }
    @Test
    public void test2() {
        // 递增栈也有可能出现 值很大的组合
        int[] arr = {9, 2, 4, 5, 1, 6, 9, 10};
        int k = 3;
        for (int i : findSmallSeq(arr, k)) {
            System.out.println(i);
            //1
            //6
            //9
        }
    }

    /**
     * TODO 找出最小序列
     *
     * @param nums
     * @param k
     * @return
     */
    public int[] findSmallSeq(int[] nums, int k) {
        int[] ans = new int[k];
        Stack<Integer> s = new Stack();
        // 这里生成单调栈
        for (int i = 0; i < nums.length; i++) {
            final int x = nums[i];
            final int left = nums.length - i;
            // 注意我们想要提取出k个数，所以注意控制扔掉的数的个数
            while (!s.empty() && (s.size() + left > k) && s.peek() > x) {
                s.pop();
            }
            s.push(x);
        }
        // 如果递增栈里面的数太多，那么我们只需要取出前k个就可以了。
        // 多余的栈中的元素需要扔掉。
        while (s.size() > k) {
            s.pop();
        }
        // 把k个元素取出来，注意这里取的顺序!
        for (int i = k - 1; i >= 0; i--) {
            ans[i] = s.peek();
            s.pop();
        }
        return ans;
    }

}
