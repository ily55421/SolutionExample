package com.leetcode.unit;

/**
 * @Author: linK
 * @Date: 2022/7/21 15:35
 * @Description TODO
 */
public class StrKit {
    public static void main(String[] args) {
        System.out.println(replace("maximum-depth-of-n-ary-tree"));
    }
    public static String replace(String str){
        return str.replaceAll("-", "_");
    }
}
