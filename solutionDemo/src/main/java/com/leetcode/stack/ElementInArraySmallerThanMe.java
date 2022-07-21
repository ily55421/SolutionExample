package com.leetcode.stack;

import org.junit.Test;

import java.util.Arrays;
import java.util.Stack;

/**
 * @Author: linK
 * @Date: 2022/7/21 10:30
 * @Description TODO
 * 数组中比我小的元素
 * 小的数要与大的数配对
 * 小的数会消除大的数
 *
 * <p>
 *     如果我们进一步归纳，会发现消除的时候，这里仍然是消除一个元素，保留一个元素。弹栈的时候，仍然是一直弹栈，直到满足某个条件为止。
 *     只是条件变成了直到元素大于栈顶元素。
 * </p>
 */
public class ElementInArraySmallerThanMe {
    @Test
    public void test() {
        int[] arr = {5, 2};
        Arrays.stream(findRightSmall(arr)).forEach(System.out::println);
        // 1     -1
    }

    @Test
    public void testTure() {
        int[] arr = {5, 2};
        Arrays.stream(findRightSmallTure(arr)).forEach(System.out::println);
        // 1     -1
    }

    @Test
    public void testBig() {
        int[] arr = {5, 2};
        //右边比第一个大的
        Arrays.stream(findRightBigTure(arr)).forEach(System.out::println);
        //-1
        //-1
    }

    @Test
    public void testBig2() {
        int[] arr = {5, 2, 7};
        //右边比第一个大的
        Arrays.stream(findRightBigTure(arr)).forEach(System.out::println);
        //2
        //2
        //-1
    }

    @Test
    public void testLeftSmall() {
        int[] arr = {5, 2, 7};
        //左边比我小的
        Arrays.stream(findLeftCloseSmallTure(arr)).forEach(System.out::println);
        //-1
        //-1
        //1
    }
    @Test
    public void testLeftBig() {
        int[] arr = {5, 2, 7};
        //左边比我小的
        Arrays.stream(findLeftCloseBigTure(arr)).forEach(System.out::println);
        //-1
        //0
        //-1
    }
    int[] findRightSmall(int[] a) {
        if (a.length <= 1 || a == null) {
            return null;
        }
        Stack<Integer> stack = new Stack<>();
        stack.push(a[0]);
        // 声明一个对应数组的容量
        int[] arr = new int[a.length];
        for (int i = 1; i < a.length; i++) {
            final int var = a[i];
            // 数值比较  比较的索引
//            if (a[stack.peek()] > var) {
//                //添加数组的索引的值
//                arr[i - 1] = i;
            while (!stack.empty() && a[stack.peek()] > var) {
                //记录被谁干掉的
                arr[stack.peek()] = i;
                stack.pop();
            }
            //当前没有比我自己小的压栈
            stack.push(a[i]);
//            } else {

//            }
        }
        if (!stack.empty()) {
            //最后一位默认为-1 无比较对象
//            arr[a.length - 1] = -1;
            arr[stack.peek()] = -1;
            stack.pop();

        }

        return arr;
    }

    /**
     * 消除左边大的数据
     *
     * @param A
     * @return
     */
    public static int[] findRightSmallTure(int[] A) {
        // 结果数组
        int[] ans = new int[A.length];
        // 注意，栈中的元素记录的是下标(索引 int值)
        Stack<Integer> t = new Stack();
        for (int i = 0; i < A.length; i++) {
            final int x = A[i];
            // 每个元素都向左遍历栈中的元素完成消除动作
            while (!t.empty() && A[t.peek()] > x) {
                // 消除的时候，记录一下被谁消除了
                ans[t.peek()] = i;
                // 消除时候，值更大的需要从栈中消失
                t.pop();
            }
            // 剩下的入栈
            t.push(i);
        }
        // 栈中剩下的元素，由于没有人能消除他们，因此，只能将结果设置为-1。
        while (!t.empty()) {
            ans[t.peek()] = -1;
            t.pop();
        }
        return ans;
    }

    /**
     * 数组中右边第一个比我大的元素的位置
     *
     * @param A
     * @return
     */
    public static int[] findRightBigTure(int[] A) {
        // 结果数组
        int[] ans = new int[A.length];
        // 注意，栈中的元素记录的是下标(索引 int值)
        Stack<Integer> t = new Stack();
        for (int i = 0; i < A.length; i++) {
            final int x = A[i];
            // 每个元素都向左遍历栈中的元素完成消除动作
            while (!t.empty() && A[t.peek()] < x) {
                // 消除的时候，记录一下被谁消除了
                ans[t.peek()] = i;
                // 消除时候，值更大的需要从栈中消失
                t.pop();
            }
            // 剩下的入栈
            t.push(i);
        }
        // 栈中剩下的元素，由于没有人能消除他们，因此，只能将结果设置为-1。
        while (!t.empty()) {
            ans[t.peek()] = -1;
            t.pop();
        }
        return ans;
    }

    /**
     * 数组中元素左边离我最近且比我小的元素的位置
     *
     * @param A
     * @return
     */
    public static int[] findLeftCloseSmallTure(int[] A) {
        // 结果数组
        int[] ans = new int[A.length];
        // 注意，栈中的元素记录的是下标(索引 int值)
        Stack<Integer> t = new Stack();
        boolean flag = false;
        for (int i = 0; i < A.length; i++) {
            final int x = A[i];
            // 每个元素都向左遍历栈中的元素完成消除动作
            while (!t.empty() && A[t.peek()] < x) {
                // 消除的时候，记录一下被谁消除了
                ans[i] = t.peek();
                // 消除时候，值更大的需要从栈中消失
                t.pop();
                flag = true;
                // 只消除一次
                break;
            }
            // 如果没有找到左边为最小的元素位置 直接赋值为-1
            if (!flag) {
                ans[i] = -1;

            }
            // 剩下的入栈
            t.push(i);
            //重置状态
            flag = false;
        }
        // 栈中剩下的元素，由于没有人能消除他们，因此，只能将结果设置为-1。
//        while (!t.empty()) {
//            ans[t.peek()] = -1;
//            t.pop();
//        }
        return ans;
    }

    /**
     * 数组中元素左边离我最近且比我大的元素的位置
     *
     * @param A
     * @return
     */
    public static int[] findLeftCloseBigTure(int[] A) {
        // 结果数组
        int[] ans = new int[A.length];
        // 注意，栈中的元素记录的是下标(索引 int值)
        Stack<Integer> t = new Stack();
        boolean flag = false;
        for (int i = 0; i < A.length; i++) {
            final int x = A[i];
            // 每个元素都向左遍历栈中的元素完成消除动作
            while (!t.empty() && A[t.peek()] > x) {
                // 消除的时候，记录一下被谁消除了
                ans[i] = t.peek();
                // 消除时候，值更大的需要从栈中消失
                t.pop();
                flag = true;
                // 只消除一次
                break;
            }
            // 如果没有找到左边为最小的元素位置 直接赋值为-1
            if (!flag) {
                ans[i] = -1;
            }
            // 剩下的入栈
            t.push(i);
            //重置状态
            flag = false;
        }

        return ans;
    }
}
