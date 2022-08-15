// https://www.acwing.com/problem/content/description/788/
package com.leetcode.tip08Sort;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

/**
 * @author 14688
 */
public class 第k个数heap786 {
  static int[] A = new int[100001];
  public static void main(String args[]) throws Exception {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int k = sc.nextInt();

    for (int i = 0; i < n; i++) {
      A[i] = sc.nextInt();
    }
    // 这里用最大堆
    Queue<Integer> Q = new PriorityQueue<>((v1, v2) -> v2 - v1);
    for (int i = 0; i < n; i++) {
      final int x = A[i];
      Q.offer(x);
      while (Q.size() > k) {
        Q.poll();
      }
    }
    System.out.println(Q.peek());
  }
}
