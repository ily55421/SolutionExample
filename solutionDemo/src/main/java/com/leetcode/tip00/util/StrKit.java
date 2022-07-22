package com.leetcode.tip00.util;

/**
 * @Author: linK
 * @Date: 2022/7/21 15:35
 * @Description TODO
 */
public class StrKit {
    public static void main(String[] args) {
        System.out.println(replace("zui-xiao-de-kge-shu-lcof"));
    }
    public static String replace(String str){
        return str.replaceAll("-", "_");
    }
}
