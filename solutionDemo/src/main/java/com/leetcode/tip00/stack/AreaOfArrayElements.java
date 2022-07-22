package com.leetcode.tip00.stack;

import org.junit.Test;

import java.util.Stack;

/**
 * @Author: linK
 * @Date: 2022/7/21 14:25
 * @Description TODO 数组元素求面积
 * <p>
 * 给定一个数组，数组中的元素代表木板的高度。请你求出相邻
 * 木板能剪出的最大矩形面积。
 * </P>
 */
public class AreaOfArrayElements {
    @Test
    public void test() {
        // 递增栈也有可能出现 值很大的组合
        int[] arr = {9, 2, 4, 5, 1, 6, 9, 10};
        int k = 3;
        System.out.println(findArray(arr, k));
        //18
    }
    @Test
    public void test2() {
        // 递增栈也有可能出现 值很大的组合
        int[] arr = {9, 2};
        int k = 3;
        System.out.println(findArray2(arr, k));
        //4
    }
    @Test
    public void test3() {
        // 递增栈也有可能出现 值很大的组合
        int[] arr = {9, 2, 4, 5, 1, 6, 9, 10};
        int k = 3;
        System.out.println(findArray(arr, k));
        //18
    }
    /**
     * 给定一个数组，数组中的元素代表木板的高度。请你求出相邻
     * 木板能剪出的最大矩形面积。
     *
     * @param arr
     * @param k
     * @return
     */
    public int findArray(int[] arr, int k) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        if (arr.length == 1) {
            return arr[0];
        }
        Stack<Integer> s = new Stack<>();
        int[] count = new int[k];

        for (int i = 0; i < arr.length; i++) {
            final int x = arr[i];
            // 剩余个数
            final int left = arr.length - i;
            int countArea = 0;
            // 数组临时存放相邻数据
            if (i > k - 1) {
                count[i % k] = arr[i];
            } else {
                count[i] = arr[i];
            }
            // 计算面积
            if (count.length == k) {
                int temp = count[0];
                for (int j = 1; j < count.length; j++) {
                    if (count[j] < temp) {
                        temp = count[j];
                    }
                }
                countArea = temp * k;
            }
            //每次比较面积 最大的入栈
            while (!s.empty() && s.peek() <= countArea) {
                s.pop();
            }
            s.push(countArea);

        }
        return s.pop();
    }

    public int findArray2(int[] arr, int k) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        if (arr.length < k) {
            return calculateArea(arr, k);
        }
        Stack<Integer> s = new Stack<>();
        int[] count = new int[k];

        for (int i = 0; i < arr.length; i++) {
            final int x = arr[i];
            // 剩余个数
            final int left = arr.length - i;
            int countArea = 0;
            // 数组临时存放相邻数据
            if (i > k - 1) {
                count[i % k] = arr[i];
            } else {
                count[i] = arr[i];
            }
            // 计算面积
            countArea = calculateArea(count, k);
            //每次比较面积 最大的入栈
            while (!s.empty() && s.peek() <= countArea) {
                s.pop();
            }
            s.push(countArea);

        }
        return s.pop();
    }

    /**
     * 计算相邻面积的方法
     *
     * @param count
     * @param k
     * @return
     */
    public int calculateArea(int[] count, int k) {
        int countArea = 0;
        // 计算面积
        if (count.length < k) {
            k = count.length;
        }
        int temp = count[0];
        for (int j = 1; j < count.length; j++) {
            if (count[j] < temp) {
                temp = count[j];
            }
        }
        countArea = temp * k;
        return countArea;
    }
}
