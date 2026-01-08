// Last updated: 1/8/2026, 11:54:34 PM
1class Solution {
2        public int countHousePlacements(int n) {
3        int a = 1, b = 1, c = 2, mod = (int)1e9 + 7;
4        for (int i = 0; i < n; ++i) {
5            c = (a + b) % mod;
6            a = b;
7            b = c;
8        }
9        return (int)(1L * b * b % mod);
10    }
11}