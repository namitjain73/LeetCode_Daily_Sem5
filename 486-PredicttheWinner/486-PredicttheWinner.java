// Last updated: 8/1/2026, 8:42:34 PM
1class Solution {
2    public boolean predictTheWinner(int[] nums) {
3        int n = nums.length;
4        int[][] dp = new int[n][n];
5        for(int[] d : dp) Arrays.fill(d , -1);
6        int sum = 0 ;
7        for(int i : nums) sum += i;
8        int ans = solver(0 , n-1 , nums , dp);
9        return ans >= (sum - ans) ? true : false;
10    }
11    public int solver(int i , int j , int[] arr , int[][] dp){
12        if(i > j) return 0;
13        if(dp[i][j] != -1) return dp[i][j];
14
15        int fs = arr[i] + Math.min(solver(i+2 , j , arr , dp) , solver(i+1 , j-1 , arr , dp));
16        int ss = arr[j] + Math.min(solver(i+1 , j-1 , arr , dp) , solver(i , j-2 , arr , dp));
17        int ans = Math.max(fs , ss);
18        return dp[i][j] = ans;
19    }
20}