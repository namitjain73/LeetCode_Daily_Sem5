// Last updated: 4/16/2026, 1:27:57 AM
1class Solution {
2    public int nthUglyNumber(int n) {
3        int[] dp = new int[n];
4        dp[0] = 1;
5
6        int i2 = 0, i3 = 0, i5 = 0;
7
8        for(int i = 1; i < n; i++){
9            int next = Math.min(dp[i2]*2, 
10                        Math.min(dp[i3]*3, dp[i5]*5));
11
12            dp[i] = next;
13
14            if(next == dp[i2]*2) i2++;
15            if(next == dp[i3]*3) i3++;
16            if(next == dp[i5]*5) i5++;
17        }
18
19        return dp[n-1];
20    }
21}