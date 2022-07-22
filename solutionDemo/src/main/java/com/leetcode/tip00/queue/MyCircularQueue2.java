package com.leetcode.tip00.queue;

/**
 * @Author: linK
 * @Date: 2022/7/21 16:46
 * @Description TODO 循环队列  Tips: (增加一个元素空间用于比较)使用 k+1 个元素的空间，两个变量 front, rear 来控制循环队列的使用。
 * <p>
 * 【方法 2】方法 1 利用 used 变量对满队列和空队列进行了区分。实际上，这种区分方式
 * 还有另外一种办法，使用 k+1 个元素的空间，两个变量 front, rear 来控制循环队列的使
 * 用。具体如下：
 * 在申请数组空间的时候，申请 k + 1 个空间；
 * 在放满循环队列的时候，必须要保证 rear 与 front 之间有空隙。
 * </p>
 * <p>
 * 此时，可以发现，循环队列实际上是浪费了一个元素的空间。这个浪费的元素必须卡在
 * front 与 rear 之间。判断队列空或者满可以：
 * front == rear 此时队列为空；
 * (rear + 1) % capacity == front，此时队列为满。
 * </p>
 *
 * <p>
 *     TODO 注意：由于浪费了一个元素的空间，在申请数组的时候，要申请的空间大小为 k +1, 并且 capacity 也必须为 k + 1。
 *     除此之后，由于是循环数组，下标的活动范围是[0, k]（capacity 为 k+1，所以最大只能取到k）。下标的移动仍然需要利用取模的技巧。
 *  </p>
 *
 *  <P>
 * TODO 分析
 * 1. 相似点
 * 两种方法都是利用了取模的技巧，强调一下，在取模的时候，如果需要向前移动，不要写
 * 成 (i - 1) % capacity，注意一定要加上 capacity 之后再取模，否则在 i = 0 的时候就出错
 * 了。
 * 2. 差别
 * 这两种方法的唯一区别在于区分空队列与满队列时，方法不一样：
 * TODO 方法 1 引入了另外一个变量 used 进行区分
 * TODO 方法 2 采用了浪费一个存储空间的办法进行区分
 * 3. 适用范围
 * 你可能认为方法 2 在队列元素较大时，存在浪费的情况，实际上这两种办法都有不同的适用范围。
 *  方法 1 的缺点在于控制变量较多，达到 3 个。
 *  而方法 2 虽然浪费了一个存储空间，但是控制变量较少，只有 2 个。
 * TODO 在多线程编程里面，控制变量越少，越容易实现无锁编程，因此，在无锁队列里面，利用方法 2 较容易实现无锁队列。
 *  </P>
 *
 */
public class MyCircularQueue2 {
    // 队列的头部元素所在位置
    private int front = 0;
    // 队列的尾巴
    // 注意我们采用的是前开后闭原则
    // [front, rear)
    private int rear = 0;
    private int[] a = null;
    private int capacity = 0;

    /**
     * TODO 初始化队列时 数量增加1
     * @param k
     */
    public MyCircularQueue2(int k) {
        // 初始化队列，注意此时队列中元素个数为
        // k + 1
        capacity = k + 1;
        a = new int[k + 1];
    }

    public boolean enQueue(int value) {
        // 如果已经满了，无法入队
        if (isFull()) {
            return false;
        }
        // 把元素放到rear位置
        a[rear] = value;
        // rear向后移动
        rear = (rear + 1) % capacity;
        return true;
    }

    public boolean deQueue() {
        // 如果为空，无法出队
        if (isEmpty()) {
            return false;
        }
        // 出队之后，front要向前移
        front = (front + 1) % capacity;
        return true;
    }

    public int Front() {
        // 如果能取出第一个元素，取a[front];
        return isEmpty() ? -1 : a[front];
    }

    public int Rear() {
        // 由于我们使用的是前开后闭原则
        // [front, rear)
        // 所以在取最后一个元素时，应该是
        // (rear - 1 + capacity) % capacity;
        int tail = (rear - 1 + capacity) % capacity;
        return isEmpty() ? -1 : a[tail];
    }

    public boolean isEmpty() {
        // 队列是否为空
        return front == rear;
    }

    public boolean isFull() {
        // rear与front之间至少有一个空格
        // 当rear指向这个最后的一个空格时，
        // 队列就已经放满了!
        return (rear + 1) % capacity == front;
    }


}
