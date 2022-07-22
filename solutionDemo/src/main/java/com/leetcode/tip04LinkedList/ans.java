package com.leetcode.tip04LinkedList;

class ListNode04 {
    public int val = 0;
    public ListNode04 next = null;

    public ListNode04() {

    }

    public ListNode04(int x) {
        val = x;
    }
}

public class ans {

    /*
     * 思考题：如果在链表中进行查找的时候， 给定的并不是下标， 而是一个数 target， 或者是一个结点 ListNode04 target，
     * 应该如何正确地编写这个查找函数呢？
     *
     * 注意：给定的参数链表头head并不是一个假头
     */
    // 如果给定的不是下标，而是一个具体的数值。
    static private ListNode04 findNode(ListNode04 head, int target) {
        ListNode04 p = head;
        while (p != null) {
            if (p.val == target) {
                return p;
            }
            p = p.next;
        }
        return null;
    }

    // 如果给定的是一个ListNode04 *target
    static private ListNode04 findNode(ListNode04 head, ListNode04 target) {
        ListNode04 p = head;
        while (p != null && target != null) {
            if (p == target) {
                return p;
            }
            p = p.next;
        }
        return null;
    }

    // ------------ PART 2 -----------------------

    // 但是有时候，往往找到这个target之后，我们还需要执行一些操作。
    // 比如将这个target给删除掉的操作。那么，找到target的前面一个结点
    static private ListNode04 getPrevNode(ListNode04 dummy, int target) {
        ListNode04 pre = dummy;
        ListNode04 p = dummy.next;

        while (p != null) {
            if (p.val == target) {
                return pre;
            }
            pre = p;
            p = p.next;
        }

        return pre;
    }

    // 当给定的链表不是一个带dummy head的链表的时候，我们改造成一个带dummy
    // head的链表再操作
    static private ListNode04 deleteNode(ListNode04 head, int target) {
        ListNode04 dummy = new ListNode04();
        dummy.next = head;

        ListNode04 pre = getPrevNode(dummy, target);

        // 删除结点
        if (pre.next != null) {
            pre.next = pre.next.next;
        }

        return dummy.next;
    }

    // ========= TEST CODE ==============

    // 以下是测试代码
    private static ListNode04 fromArrayToList(int[] A) {
        ListNode04 dummy = new ListNode04();
        ListNode04 tail = dummy;
        for (int x : A) {
            ListNode04 p = new ListNode04(x);
            tail.next = p;
            tail = tail.next;
        }
        tail.next = null;
        return dummy.next;
    }

    public static void main(String[] args) {
        int[] A = new int[] { 1, 2, 3, 4, 5, 6, 7 };
        ListNode04 head = fromArrayToList(A);
        for (int x : A) {
            ListNode04 ret = findNode(head, x);
            assert ret.val == x;

            assert ret == findNode(head, ret);
        }
    }
}