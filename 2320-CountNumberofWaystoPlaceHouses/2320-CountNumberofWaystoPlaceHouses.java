// Last updated: 2/2/2026, 10:42:50 PM
1class Solution {
2    public int countHousePlacements(int n) {
3        int a = 1;
4        int b= 1;
5        int c = 2;
6        int mod = (int)1e9 + 7;
7        for(int i  = 0 ;i < n ; i++){
8            c = (a+b)% mod;
9            a = b % mod;
10            b = c % mod;
11        }
12        return (int)(1L * b * b % mod);
13    }
14}