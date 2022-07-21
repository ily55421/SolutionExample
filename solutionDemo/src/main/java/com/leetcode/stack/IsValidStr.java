package com.leetcode.stack;

import org.junit.Before;
import org.junit.Test;

import java.util.Stack;

/**
 * @Author: linK
 * @Date: 2022/7/21 8:58
 * @Description TODO 例 1：判断字符串括号是否合法  ：()，()()，(())是合法的。)(，()(，(()是非法的。
 * <p>
 * 归纳为“四步分析法”。
 * 1.模拟：模拟题目的运行。
 * 2.规律：尝试总结出题目的一般规律和特点。
 * 3.匹配：找到符合这些特点的数据结构与算法。
 * 4.边界：考虑特殊情况。
 * </P>
 *
 * <p>
 * 1. 深度扩展
 * 如果仔细观察，你会发现，栈中存放的元素是一样的。全部都是左括号'('，除此之外，再
 * 也没有别的元素，优化方法如下。
 * TODO 栈中元素都相同时，实际上没有必要使用栈，只需要记录栈中元素个数。
 * </p>
 *
 * <p>
 * 2. 广度扩展
 * 【题目扩展】给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。有
 * 效字符串需满足：
 * 1.左括号必须用相同类型的右括号闭合
 * 2.左括号必须以正确的顺序闭合
 * 3.注意空字符串可被认为是有效字符串
 * </P>
 */
public class IsValidStr {
    private String[] strS = null;
    private String[] strS2 = null;


    @Before
    public void init() {
        String str1 = "";
        String str2 = "(";
        String str3 = ")";
        String str4 = "()";
        String str5 = "(((((())))))()";
        String str6 = "((((())))))()";
        strS = new String[]{str1, str2, str3, str4, str5, str6};

        // 拓展二  增加两种类型符号
        String str7 = "{}{}[][)((((())))))()";
        String str8 = "{}{}[][([)}}()";
        strS2 = new String[]{str1, str2, str3, str4, str5, str6, str7, str8};

    }

    @Test
    public void test() {

        for (int i = 0; i < strS.length; i++) {
            System.out.println(isValid(strS[i]));
            //false
            //false
            //false
            //true
            //true
        }

    }

    @Test
    public void test2() {

        for (int i = 0; i < strS.length; i++) {
            System.out.println(isValid2(strS[i]));
            //true
            //false
            //false
            //true
            //true
            //false
        }

    }

    @Test
    public void test3() {

        for (int i = 0; i < strS.length; i++) {
            System.out.println(isValid3(strS[i]));
            //true
            //false
            //false
            //true
            //true
            //false
        }

    }

    @Test
    public void testStack() {
        // stack实现的测试
        for (int i = 0; i < strS.length; i++) {
            System.out.println(isValidStack(strS[i]));
            //true
            //false
            //false
            //true
            //true
            //false
        }

    }

    @Test
    public void testStack2() {
        // stack实现的测试
        for (int i = 0; i < strS2.length; i++) {
            System.out.println(isValidStack2(strS2[i]));
            //true
            //false
            //false
            //true
            //true
            //false
            //false
            //false
        }

    }

    /**
     * )(，()(，(()是非法的。 没有进行对称判断
     *
     * @param s
     * @return
     */
    public boolean isValid(String s) {
        char[] chars = s.toCharArray();
        int count = 0;
        if (chars.length == 0 || chars.length == 1) {
            return false;
        }

        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '(') {
                count++;
            }
            if (chars[i] == ')') {
                count--;
            }
        }

        return count == 0;
    }

    public boolean isValid2(String s) {
//        char[] chars1 = s.toCharArray();
//
//        if (chars1.length == 0 || chars1.length == 1) {
//            return false;
//        }
        // 修改奇数判断和非空判断
        if (s == null || s.length() == 0) {
            return true;
        }
        if (s.length() % 2 == 1) {
            return false;
        }
        int count = 0;
        // 更换api调用
        for (int i = 0; i < s.length(); i++) {

            if (s.charAt(i) == '(') {
                count++;
                //减少一次判断
                continue;
            }
            if (s.charAt(i) == ')') {
                count--;
            }
        }
        return count == 0;
    }

    public boolean isValid3(String s) {

        if (nullValid(s)) {
            return true;
        }
        if (s.length() % 2 == 1) {
            return false;
        }
        int count = 0;
        // 更换api调用
        for (int i = 0; i < s.length(); i++) {

            if (s.charAt(i) == '(') {
                count++;
                //减少一次判断
                continue;
            }
            if (s.charAt(i) == ')') {
                // 模拟弹栈
                if (count <= 0) {
                    return false;
                }
                count--;
            }
        }
        return count == 0;
    }

    /**
     * 判空方法抽出
     *
     * @param s
     * @return
     */
    public boolean nullValid(String s) {
        // 修改奇数判断和非空判断
        if (s == null || s.length() == 0) {
            return true;
        }
        return false;
    }

    /**
     * TODO 消除法：使用栈的方式进行判断
     * ( 压栈
     * ) 弹栈
     *
     * @param s
     * @return
     */
    public boolean isValidStack(String s) {
        //当字符串本来就是空的时候，我们可以快速返回true
        if (s == null || s.length() == 0) {
            return true;
        }
        //当字符串长度为奇数的时候，不可能是一个有效的合法字符串

        if (s.length() % 2 == 1) {
            return false;
        }
        // 消除法的主要核心逻辑
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            // 取出字符
            char c = s.charAt(i);
            if (c == '(') {
                // 如果是'(',那么压栈
                stack.push(c);
            } else if (c == ')') {
                // 如果是')',那么就尝试弹栈
                if (stack.empty()) {
                    // 栈的非空判断防止溢出, 如果弹栈失败，那么返回false
                    return false;
                }
                // 弹栈
                stack.pop();
            }

        }


        return stack.empty();
    }

    /**
     * TODO 消除法：增加符号扩展
     *
     * @param s
     * @return
     */
    public boolean isValidStack2(String s) {
        //当字符串本来就是空的时候，我们可以快速返回true
        if (s == null || s.length() == 0) {
            return true;
        }
        //当字符串长度为奇数的时候，不可能是一个有效的合法字符串

        if (s.length() % 2 == 1) {
            return false;
        }
        // 消除法的主要核心逻辑
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            // 取出字符
            char c = s.charAt(i);
            if (c == '(' || c == '{' || c == '[') {
                // 如果是'(',那么压栈
                stack.push(c);
            } else if (c == ')' || c == '}' || c == ']') {
                // 如果是')',那么就尝试弹栈
                if (stack.empty()) {
                    // 栈的非空判断防止溢出, 如果弹栈失败，那么返回false
                    return false;
                }
                // 弹栈
                Character pop = stack.pop();
                // 判断弹出字符类型是否匹配
                if (validStack(c, pop)) {
                    System.out.println(String.format("%s 符号类型不匹配,应该是 %s", pop, c));
                    return false;
                }
            }

        }


        return stack.empty();
    }

    public boolean validStack(Character c, Character pop) {
        if (c == ')' && pop != '(') {
            return true;
        }
        if (c == ']' && pop != '[') {
            return true;
        }
        if (c == '}' && pop != '{') {
            return true;
        }

        return false;
    }
}
