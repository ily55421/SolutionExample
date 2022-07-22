package com.leetcode.tip00.queue;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Author: linK
 * @Date: 2022/7/21 15:01
 * @Description TODO 02 队列：FIFO 队列与单调队列的深挖与扩展
 * TODO 【题目扩展】切忌盲目刷题，其实只要吃透一道题，就可以解决很多类似的题目。
 * <p>
 * 在计算机系统中常用先进先出（First In First Out）的队列来表示这种场景。
 * <p>
 * 但是除了这种 FIFO 队列以外，还有一种队列需要注意，就是单调队列，由于课本上不常讲，面试中又容易出现，因此需要格外注意。
 * </p>
 * <p>
 * 2. 规律
 * 通过运行的模拟，可以总结出以下两个特点。
 * （1）广度遍历（层次遍历）：由于二叉树的特点，当我们拿到第 N 层的结点 A 之后，
 * 可以通过 A 的 left 和 right 指针拿到下一层的结点。
 * （2）顺序输出：每层输出时，排在左边的结点，它的子结点同样排在下一层最左
 * 边。
 * 3. 匹配
 * 当你发现题目具备广度遍历（分层遍历）和顺序输出的特点，就应该想到用FIFO 队
 * 列来试一试。
 * 4.. 边界
 * 关于二叉树的边界，需要考虑一种空二叉树的情况。当遇到一棵空的二叉树，有两种解决
 * 办法。
 * （1）特殊判断：如果发现是一棵空二叉树，就直接返回空结果。
 * （2）制定一个规则：不要让空指针进入到 FIFO 队列。
 * 我个人比较喜欢第 2 种方案，因为代码一致性更好（一致性是指不需要为各种特殊情况再
 * 添加额外的 if/else 来处理）。所以接下来我将从“制定一个规则：不要让空指针进入队
 * 列”上考虑代码的实现。
 * </p>
 * <p>
 * 分层遍历
 * 顺序遍历
 * </p>
 */
public class PreambleLevelOrder {
    /**
     * Step1. 在一开始首先将根结点 3 加入队列中。
     * Step 2. 开始新一层遍历，记录下当前队列长度 QSize=1，初始化当前层存放结果的[]。
     * Step 3. 将结点 3 出队，然后将其放到当前层中。
     * Step 4. 再将结点 3 的左右子结点分别入队。QSize = 1 的这一层已经处理完毕。
     * Step 5. 开始新一层的遍历。记录下新一层的 QSize = 2，初始化新的当前层存放当前层结
     * 果的[]。
     * Step 6. 从队列中取出 9，放到当前层结果中。结点 9 没有左右子结点，不需要继续处理左
     * 右子结点。
     * Step 7. 从队列中取出 8，放到当前层结果中。
     * Step 8. 将结点 8 的左右子结点分别入队。此时，QSize = 2 的部分已经全部处理完成。
     * Step 9.开始新一层的遍历，记录下当前队列中的结点数 QSize = 2，并且生成存放当前层
     * 结果的 list[]。
     * Step 10. 将队首结点 6 出队放到当前层结果中。结点 6 没有左右子结点，没有元素要入
     * 队。
     * Step 11. 将队首结点 7 出队，放到当前层结果中。结点 7 没有左右子结点，没有元素要入
     * 队。
     * 结束，返回我们层次遍历的结果。
     *
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(com.leetcode.queue.TreeNode root) {
        // 生成FIFO队列
        Queue<com.leetcode.queue.TreeNode> Q = new LinkedList<>();
        // 如果结点不为空，那么加入FIFO队列
        if (root != null) {
            Q.offer(root);
        }
        // ans用于保存层次遍历的结果
        List<List<Integer>> ans = new LinkedList<>();
        // 开始利用FIFO队列进行层次遍历
        while (Q.size() > 0) {
            // 取出当前层里面元素的个数
            final int qSize = Q.size();
            // 当前层的结果存放于tmp链表中
            List<Integer> tmp = new LinkedList<>();
            // 遍历当前层的每个结点
            for (int i = 0; i < qSize; i++) {
                // 当前层前面的结点先出队
                com.leetcode.queue.TreeNode cur = Q.poll();
                // 把结果存放当于当前层中
                tmp.add(cur.val);
                // 把下一层的结点入队，注意入队时需要非空才可以入队。
                if (cur.left != null) {
                    Q.offer(cur.left);
                }
                if (cur.right != null) {
                    Q.offer(cur.right);
                }
            }
            // 把当前层的结果放到返回值里面。
            ans.add(tmp);
        }
        return ans;
    }

    /**
     * 中序遍历 根节点 左节点 右节点
     * 【解法二】再来回顾一下题目的特点：
     * 分层遍历
     * 顺序遍历
     * 那么我们是不是可以用 List 来表示每一层，把下一层的结点统一放到一个新生成的 List 里面。
     * <p>
     * Step 1. 首先将结点 3 加入 cur,，形成 cur=[3]。
     * Step 2. 开始依次遍历当前层 cur, 这里 cur 只有结点 3，依次把结点 3 的左子结点和右子结
     * 点加入 next，形成 [9, 8]。
     * Step 3. 将 cur 指向 next，并且 next 设置为 []
     * Step 4. 依次遍历 cur，并将每个结点的左右子结点放到 next 中。
     * Step 5. 将 cur 指向 next。并依次遍历。由于这是最后一层，所以不会再生成 next。
     * Step 6. 最后得到层次遍历的结果。
     *
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder2(com.leetcode.queue.TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        // 初始化当前层结点
        List<com.leetcode.queue.TreeNode> curLevel = new ArrayList<>();
        // 注意：需要root不空的时候才加到里面。
        if (root != null) {
            curLevel.add(root);
        }
        while (curLevel.size() > 0) {
            // 准备用来存放下一层的结点
            List<com.leetcode.queue.TreeNode> nextLevel = new ArrayList<>();
            // 用来存放当前层的结果
            List<Integer> curResult = new ArrayList<>();
            // 遍历当前层的每个结点
            for (com.leetcode.queue.TreeNode cur : curLevel) {
                // 把当前层的值存放到当前结果里面
                curResult.add(cur.val);
                // 生成下一层
                if (cur.left != null) {
                    nextLevel.add(cur.left);
                }
                if (cur.right != null) {
                    nextLevel.add(cur.right);
                }
            }
            // 注意这里的更迭!滚动前进
            curLevel = nextLevel;
            // 把当前层的值放到结果里面
            ans.add(curResult);
        }
        return ans;
    }

}
