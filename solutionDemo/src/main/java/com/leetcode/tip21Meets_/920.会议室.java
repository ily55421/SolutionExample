package com.leetcode.tip21Meets_;

import java.util.Collections;


/*
 * 描述: 
 * 给定一系列的会议时间间隔，包括起始
 * 和结束时间[[s1,e1]，[s2,e2]，…(si < ei)，
 * 确定一个人是否可以参加所有会议。
 * 
 * 样例
 * 
 * 样例1
 * 输入: intervals = [(0,30),(5,10),(15,20)]
 * 输出: false
 * 
 * 解释:
 * (0,30), (5,10) 和 (0,30),(15,20) 这两对会议会冲突
 * 
 * 样例2
 * 输入: intervals = [(5,8),(9,15)]
 * 输出: true
 * 解释:
 * 这两个时间段不会冲突
 */

/**
 * Definition of Interval:
 * public classs Interval {
 *     int start, end;
 *     Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */


import java.util.*;

 class Solution920 {
  class Interval {
    int start, end;
    Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }
  }
  /**
   * @param intervals: an array of meeting time intervals
   * @return: if a person could attend all meetings
   */
  public boolean canAttendMeetings(List<Interval> intervals) {
      // Write your code here
      // 找到不相交的会议的最多的个数
      // 在排序的时候，用结束时间排序
      Collections.sort(intervals, new Comparator<Interval>() {
        public int compare(Interval a, Interval b) {
            // 结束时间不相等 则比较谁先结束
            if (a.end != b.end) {
                return a.end - b.end;
            }
          return a.start - b.start;
        }
      });

      final int N = intervals == null ? 0 : intervals.size();

      int preEnd = -1;
      int ans = 0;

      for (int i = 0; i < N; i++) {
        final Interval range = intervals.get(i);
        // 有相交，那么这种不要
        if (range.start >= preEnd) {
          preEnd = Math.max(preEnd, range.end);
          ans++;
        }
      }

      return ans == N;
  }
}