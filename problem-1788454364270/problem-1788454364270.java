// Last updated: 9/3/2026, 10:22:44 PM
1class Solution {
2    public boolean uniformArray(int[] a) {
3        int mn = Integer.MAX_VALUE;
4        int oddCnt = 0;
5        for (int x : a) {
6            mn = Math.min(mn, x);
7            if (x % 2 == 1) oddCnt++;
8        }
9        return mn % 2 != 0 || oddCnt == 0;
10    }
11}