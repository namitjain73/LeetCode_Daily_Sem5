// Last updated: 9/9/2026, 9:39:06 AM
1class Solution {
2    public int countCommas(int n) {
3        if (n <= 999) return 0;
4
5        int totalCommas = 0;
6        long start = 1000;
7
8        while (start <= n) {
9            totalCommas += n - start + 1;
10            start *= 1000;
11        }
12
13        return totalCommas;
14    }
15}