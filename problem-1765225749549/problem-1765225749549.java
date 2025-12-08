// Last updated: 12/9/2025, 1:59:09 AM
1class Solution {
2    public int countTriples(int n) {
3        int cnt = 0;
4        for (int a = 1; a < n; a++) {
5            for (int b = a + 1; b < n; b++) {
6                int sumSquares = a * a + b * b;
7                int c = (int) Math.sqrt(sumSquares);
8                if (c * c == sumSquares && c <= n) {
9                    cnt += 2;
10                }
11            }
12        }
13        return cnt;
14    }
15}
16