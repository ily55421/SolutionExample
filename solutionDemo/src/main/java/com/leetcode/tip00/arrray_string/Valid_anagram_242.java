package com.leetcode.tip00.arrray_string;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: linK
 * @Date: 2022/7/20 13:37
 * @Description TODO   valid-anagram 242.有效的字母异位词
 * <P>
 *  ### **例题分析**
 * LeetCode 第 242 题：给定两个字符串 s 和 t，编写一个函数来判断 t 是否是 s 的字母异位词。
 * 说明：你可以假设字符串只包含小写字母。
 * **示例 1**
 * 输入: s = "anagram", t = "nagaram"
 * 输出: true
 * **示例 2**
 * 输入: s = "rat", t = "car"
 * 输出: false
 * 字母异位词，也就是两个字符串中的相同字符的数量要对应相等。例如，s 等于 “anagram”，t 等于 “nagaram”，s 和 t 就互为字母异位词。
 * 因为它们都包含有三个字符 a，一个字符 g，一个字符 m，一个字符 n，以及一个字符 r。而当 s 为 “rat”，t 为 “car”的时候，s 和 t 不互为字母异位词。
 *
 *     ### 解题思路
 * 一个重要的前提“假设两个字符串只包含小写字母”，小写字母一共也就 26 个，因此：
 * 1.  可以利用两个长度都为 26 的字符数组来统计每个字符串中小写字母出现的次数，然后再对比是否相等；
 * 2.  可以只利用一个长度为 26 的字符数组，将出现在字符串 s 里的字符个数加 1，而出现在字符串 t 里的字符个数减 1，最后判断每个小写字母的个数是否都为 0。
 * 按上述操作，可得出结论：s 和 t 互为字母异位词。
 * </P>
 */
public class Valid_anagram_242 {
    /**
     * <p>
     *     方式一 使用数组排序 然后调用equals
     *     // 直接比较是否相等
     *     if (a==a2)
     *             return true;
     *             // 是否为空
     *         if (a==null || a2==null)
     *             return false;
     *          // 比较长度是否不相等
     *         int length = a.length;
     *         if (a2.length != length)
     *             return false;
     *          // 比较每一个字符是否有不想相等
     *         for (int i=0; i<length; i++)
     *             if (a[i] != a2[i])
     *                 return false;
     *          // 返回相等结果
     *         return true;
     * </p>
     * @param s
     * @param t
     * @return
     */
    public boolean isAnagram1(String s, String t) {
        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();
        Arrays.sort(sChars);
        Arrays.sort(tChars);
        return Arrays.equals(sChars, tChars);
    }

    public boolean isAnagram2(String s, String t) {
        // 1. MAP用于统计字符出现的次数
        Map<Character, Integer> map = new HashMap<>();
        // 2.遍历添加前一个字符串的所有字符
        for (char ch : s.toCharArray()) {
            // 3.put添加 是否有key的对应值 无则返回默认值0 逐次累加
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        // 4.遍历后项比较字符出现的次数
        for (char ch : t.toCharArray()) {
            //5.获取字符出现的次数
            Integer count = map.get(ch);
            //6.字符不存在直接反悔false
            if (count == null) {
                return false;
            } else if (count > 1) {
                // 7.count值大于1（有效值）逐次减一
                map.put(ch, count - 1);
            } else {
                //8.移除count=<1时直接移除字符
                map.remove(ch);
            }
        }
        //9.判断map是否为空 是否刚好比较完成
        return map.isEmpty();
    }

    /**
     * <P>
     *     初始化两个数组
     *    分别累加对应位字符出现的次数
     *    比较出现次数是否相等
     * </P>
     * @param s
     * @param t
     * @return
     */
    public boolean isAnagram3(String s, String t) {
        //1.初始化两个数组
        int[] sCounts = new int[26];
        int[] tCounts = new int[26];
        char[] tCA = t.toCharArray();
        char[] sCA = s.toCharArray();
        //比较字符长度
        if (tCA.length!=sCA.length) {
            return false;
        }
        for (int i = 0; i < tCA.length; i++) {
            sCounts[sCA[i] - 'a']++;
            tCounts[tCA[i] - 'a']++;
        }
//        for (char ch : s.toCharArray()) {
//            //2.遍历每个字符比较与初始位'a'的差值 累加对象出现的值
//            sCounts[ch - 'a']++;
//        }
//        for (char ch : t.toCharArray()) {
//            tCounts[ch - 'a']++;
//        }
        //3.遍历整个数组,比较数组每一位的值
        for (int i = 0; i < 26; i++) {
            if (sCounts[i] != tCounts[i]) {
                //4.不相等直接返回false
                return false;
            }
        }
        //5.否则返回true
        return true;
    }

    /**
     * <p>
     *     声明一个数组
     *     对应字符位一个累加一个类减 （允许负数）
     *     最终比较出现的总次数是否为0
     * </p>
     * @param s
     * @param t
     * @return
     */
    public boolean isAnagram4(String s, String t) {
        int[] counts = new int[26];
        t.chars().forEach(tc -> counts[tc - 'a']++);
        s.chars().forEach(cs -> counts[cs - 'a']--);
        return Arrays.stream(counts).allMatch(c -> c == 0);
    }

    /**
     * <p>
     *     直接使用stream的排序 再转array
     *     调用array的equals进行比较
     * </p>
     * @param s
     * @param t
     * @return
     */
    public boolean isAnagram(String s, String t) {
        return Arrays.equals(s.chars().sorted().toArray(), t.chars().sorted().toArray());
    }



}
