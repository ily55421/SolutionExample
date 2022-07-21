package com.leetcode.stack;

import java.util.Stack;

/**
 * @Author: linK
 * @Date: 2022/7/21 9:56
 * @Description TODO 例二 大鱼吃小鱼
 * TODO 模拟 规律 匹配 边界
 * <p>
 *     在例 1 中，消除行为表现为配对的两者都会消除；
 *     在例 2 中，消除行为表现为配对的两者中有一个会被消除。
 *
 *     在例 1 中，栈中的存放的就是内容本身；
 *     在例 2 中，栈中存放的只是内容的索引，可以通过索引得到内容。
 *
 *     例1中，弹一个元素就可以；
 *     例2中，用 while 语句一直弹，直到满足某个条件为止。
 *
 * TODO  这道题的考点我们也挖掘出来了：
 *      是否会用栈来存放索引？
 *      是否想到在弹栈的时候一定要满足某个条件才停止弹栈？
 * </p>
 * <P>
 *   TODO  单调栈的定义：单调栈就是指栈中的元素必须是按照升序排列的栈，或者是降序排列的栈。对于这两种排序方式的栈，还给它们各自取了小名。
 *   递增栈的有序性，一句话：“任何时候都需要保证栈的有序性”。
 * </P>
 */
public class BigFishEatSmallFish {

    int solution(int[] fishSize, int[] fishDirection) {
        // 首先拿到鱼的数量
        // 如果鱼的数量小于等于1，那么直接返回鱼的数量
        final int fishNumber = fishSize.length;
        if (fishNumber <= 1) {
            return fishNumber;
        }
        // 0表示鱼向左游
        final int left = 0;
        // 1表示鱼向右游
        final int right = 1;
        //消除栈
        Stack<Integer> t = new Stack();
        for (int i = 0; i < fishNumber; i++) {
            // 当前鱼的情况：1，游动的方向；   2，大小
            final int curFishDirection = fishDirection[i];
            final int curFishSize = fishSize[i];
            // 当前的鱼是否被栈中的鱼吃掉了
            boolean hasEat = false;
            // TODO 非空和相遇判断
            // 如果栈中还有鱼(栈不为空)，并且栈中鱼向右，当前的鱼向左游，那么就会有相遇的可能性
            while (!t.empty() && fishDirection[t.peek()] == right &&
                    curFishDirection == left) {
                // 如果栈顶的鱼比较大，那么把新来的吃掉
                if (fishSize[t.peek()] > curFishSize) {
                    hasEat = true;
                    break;
                }
                // 如果栈中的鱼较小，那么会把栈中的鱼吃掉，栈中的鱼被消除，所以需要弹栈。
                t.pop();
            }
            // 如果新来的鱼，没有被吃掉，那么压入栈中。
            if (!hasEat) {
                t.push(i);
            }
        }
        return t.size();
    }

    public int solution2(int[] fishSize, int[] fishDisc) {
        //判断鱼的数量
        int fishSizeNum = fishSize.length;
        if (fishSizeNum <= 1) {
            return fishSizeNum;
        }
        Stack<Integer> stack = new Stack<>();
        // 1.相遇大鱼吃小鱼 弹栈的被吃掉
        return stack.size();
    }

}
