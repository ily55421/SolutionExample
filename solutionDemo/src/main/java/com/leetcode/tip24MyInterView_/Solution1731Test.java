package com.leetcode.tip24MyInterView_;

import org.junit.Assert;
import org.junit.Test;

/**
 * @Author: linK
 * @Date: 2022/7/27 16:19
 * @Description TODO
 */
public class Solution1731Test {
    @Test
    public void test(){
        Solution137I s = new Solution137I();
        int[] nums = {0, 1, 0, 1, 0, 1, 99};
        int i = s.singleNumber(nums);
        Assert.assertEquals(i,9);
    }
}
