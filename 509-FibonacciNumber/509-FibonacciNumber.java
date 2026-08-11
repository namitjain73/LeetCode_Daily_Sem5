// Last updated: 8/11/2026, 1:26:59 PM
1class Solution {
2    public int fib(int n) {
3        int[] dp = new int[n+1];
4        Arrays.fill(dp , -1);
5        return solver(n , dp);
6    }
7    public int solver(int n , int[] dp){
8        if(n <= 1) return n;
9        if(dp[n] != -1) return dp[n];
10        return dp[n] = solver(n-1 , dp) + solver(n-2 , dp);
11// tc - O(n) , sc - O(n)
12    }
13}