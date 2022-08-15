package com.leetcode.tip13DFS_BFS;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: linK
 * @Date: 2022/7/27 15:20
 * @Description TODO
 */
public class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
