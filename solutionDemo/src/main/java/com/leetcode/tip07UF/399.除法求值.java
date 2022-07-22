
package com.leetcode.tip07UF;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

// @lc code=start
class Solution399 {
  private void addToMap(String key, Map<String, Integer> H) {
    final int id = H.size();
    if (!H.containsKey(key)) {
      H.put(key, id);
    }
  }

  private int[] F = null;
  private double[] C = null;

  private void Init(int n) {
    F = new int[n];
    C = new double[n];
    for (int i = 0; i < n; i++) {
      F[i] = i;
      C[i] = 1;
    }
  }

  private int Find(int x) {
    // b用来记录起始位置
    // 因为在后面x的值会发生改变
    int b = x;
    // base用来保存从x -> .... root
    // 这条路径上所有的乘积
    // 最后保证可以得到
    // x = base * root
    double base = 1;
    while (x != F[x]) {
      base *= C[x];
      x = F[x];
    }
    // 这里x就是root
    // base x -> root的映射值
    // 把路径上的其他值一并压缩
    int root = x;
    while (F[b] != root) {
      // 修改值上的变化
      double next = base / C[b];
      C[b] = base;
      base = next;

      int par = F[b];
      F[b] = root;
      b = par;
    }
    return root;
  }

  private void Union(int T, int D, double v) {
    // T / D = v;
    // 给定的输入表示 T = v * D;
    // 那么找到T的root
    int tpar = Find(T);
    // T = C[T] * par
    int dpar = Find(D);
    // D = C[D] * dpar;

    // T = v * D = v * C[D] * dpar = C[T] * tpar;
    // 如果我们要让tpar 指向dpar
    // tpar = v * C[D] * dpar / C[T]
    F[tpar] = dpar;
    C[tpar] = v * C[D] / C[T];
  }

  public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
    // 为了方便后面操作，我们把所有的字符串都映射成整数
    Map<String, Integer> H = new HashMap<>();
    for (List<String> l : equations) {
      String t = l.get(0), d = l.get(1);
      addToMap(t, H);
      addToMap(d, H);
    }

    // 初始化并查集
    Init(H.size());

    // 开始执行Union操作
    for (int i = 0; i < equations.size(); i++) {
      List<String> l = equations.get(i);
      Union(H.get(l.get(0)), H.get(l.get(1)), values[i]);
    }

    double[] ans = new double[queries.size()];

    for (int i = 0; i < queries.size(); i++) {
      List<String> l = queries.get(i);
      int tidx = H.containsKey(l.get(0)) ? H.get(l.get(0)) : -1;
      int didx = H.containsKey(l.get(1)) ? H.get(l.get(1)) : -1;

      if (tidx == -1 || didx == -1) {
        ans[i] = -1;
      } else {
        int troot = Find(tidx);
        int droot = Find(didx);
        if (troot != droot) {
          ans[i] = -1;
        } else {
          ans[i] = C[tidx] / C[didx];
        }
      }
    }

    return ans;
  }
}
// @lc code=end
