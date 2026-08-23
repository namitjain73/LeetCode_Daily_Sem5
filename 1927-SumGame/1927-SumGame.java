// Last updated: 8/23/2026, 11:32:48 PM
1class Solution {
2  public boolean sumGame(String num) {
3    final int n = num.length();
4    double ans = 0.0;
5
6    for (int i = 0; i < n / 2; ++i)
7      ans += getExpectation(num.charAt(i));
8
9    for (int i = n / 2; i < n; ++i)
10      ans -= getExpectation(num.charAt(i));
11
12    return ans != 0.0;
13  }
14
15  private double getExpectation(char c) {
16    return c == '?' ? 4.5 : c - '0';
17  }
18}