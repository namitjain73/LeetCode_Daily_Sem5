// Last updated: 8/11/2026, 2:27:58 PM
1class Solution {
2    public int minCostClimbingStairs(int[] cost) {
3        int[] dp = new int[cost.length];
4        Arrays.fill(dp , -1);
5
6        return solver(cost , 0 , dp);
7    }
8    public int solver(int[] arr , int i , int[] dp){
9        if(i >= arr.length) return 0;
10        if(dp[i] != -1) return dp[i];
11
12        int x = arr[i] + solver(arr , i+1 , dp);
13        int y = 0;
14        if(i+1 < arr.length) y = arr[i+1] + solver(arr , i+2 , dp);
15        return dp[i] =  Math.min(x,y);
16    }
17}