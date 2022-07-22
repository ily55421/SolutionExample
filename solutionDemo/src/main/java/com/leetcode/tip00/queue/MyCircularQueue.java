package com.leetcode.tip00.queue;

/**
 * @Author: linK
 * @Date: 2022/7/21 16:22
 * @Description TODO 循环队列 设计一个可以容纳 k 个元素的循环队列。
 * <p>
 *     一种比较简单的办法就是采用 used变量，标记已经放了多少个元素在循环队列里面。
 *
 *      如图（a）所示，当队列为空的时候，used == 0；
 *      如图（b）所示，当队列满的时候，used == k。
 * </p>
 * <p>
 *     TODO 边界定义
 *     下标只能在 [0, k-1] 范围里面移动。以下 3 点需要
 * 你格外注意，正常情况下：
 * 1.
 * index = i 的后一个是 i + 1，前一个是 i - 1
 * 2.
 * index = k-1 的后一个就是 index = 0
 * 3.
 * index = 0 的前一个是 index = k-1
 * </p>
 * <p>
 *     TODO 边界具体判断
 *     这三个式子都可以利用取模的技巧来统一处理：
 * index = i 的后一个 (i + 1) % capacity
 * index = i 的前一个(i - 1 + capacity) % capacity
 * TODO 注意：所有的循环数组下标的处理都需要按照这个取模方法来。
 * </p>
 */
public  class MyCircularQueue {
    // 已经使用的元素个数
    private int used = 0;
    // 第一个元素所在位置
    private int front = 0;
    // rear是enQueue可在存放的位置
    // 注意开闭原则
    // [front, rear)
    private int rear = 0;
    // 循环队列最多可以存放的元素个数
    private int capacity = 0;
    // 循环队列的存储空间
    private int[] a = null;
    public MyCircularQueue(int k) {
        // 初始化循环队列
        capacity = k;
        a = new int[capacity];
    }
    public boolean enQueue(int value) {
        // 如果已经放满了
        if (isFull()) {
            return false;
        }
        // 如果没有放满，那么a[rear]用来存放新进来的元素
        a[rear] = value;
        // TODO rear注意取模 取模公式  (rear + 1) % capacity
        rear = (rear + 1) % capacity;
        // 已经使用的空间
        used++;
        // 存放成功!
        return true;
    }
    public boolean deQueue() {
        // 如果是一个空队列，当然不能出队
        if (isEmpty()) {
            return false;
        }
        // 第一个元素取出
        int ret = a[front];
        // 注意取模
        front = (front + 1) % capacity;
        // 已经存放的元素减减
        used--;
        // 取出元素成功
        return true;
    }
    public int Front() {
        // 如果为空，不能取出队首元素
        if (isEmpty()) {
            return -1;
        }
        // 取出队首元素
        return a[front];
    }
    public int Rear() {
        // 如果为空，不能取出队尾元素
        if (isEmpty()) {
            return -1;
        }
        // 注意：这里不能使用rear - 1
        // 需要取模  0 的前一位 是 capacity -1
        int tail = (rear - 1 + capacity) % capacity;
        return a[tail];
    }
    // 队列是否为空
    public boolean isEmpty() {
        return used == 0;
    }
    // 队列是否满了
    public boolean isFull() {
        return used == capacity;
    }


}
