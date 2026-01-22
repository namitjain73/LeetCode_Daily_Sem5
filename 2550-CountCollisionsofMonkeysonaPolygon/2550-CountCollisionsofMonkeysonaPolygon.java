// Last updated: 1/22/2026, 11:51:09 PM
1class Solution {
2    public int monkeyMove(int n) {
3        int mod = 1000000007;
4        int ans = (int) power(2, n, mod) - 2;
5        return ans + ((ans < 0)? mod : 0);
6    }
7    
8    private long power(long x, int y, int mod) {
9        long res = 1;
10        x %= mod; 
11        if (x == 0) {
12            return 0;
13        } 
14        while (y > 0) {
15            if ((y & 1) == 1) {
16                res = (res * x) % mod;
17            }
18            y >>= 1; 
19            x = (x * x) % mod;
20        }
21        
22        return res;
23    }
24}