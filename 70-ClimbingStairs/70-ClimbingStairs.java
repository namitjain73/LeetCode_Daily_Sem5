// Last updated: 8/11/2026, 1:21:25 PM
1class Solution {
2    public int climbStairs(int n) {
3        int[] dp = new int[n+1];
4        Arrays.fill(dp , -1);
5        return solver(n,dp);
6    }
7    public int solver(int n , int[] dp){
8        if(n == 0) return 1;
9        if(n < 0) return 0;
10        if(dp[n] != -1) return dp[n];
11
12        int res = solver(n-1 , dp) + solver(n-2 , dp);
13        return dp[n] = res;
14
15        // tc - O(n) , sc - O(n)
16     }
17}