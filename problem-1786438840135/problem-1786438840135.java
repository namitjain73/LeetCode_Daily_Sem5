// Last updated: 8/11/2026, 2:30:40 PM
1class Solution {
2    public int rob(int[] nums) {
3        int[] dp = new int[nums.length];
4        Arrays.fill(dp , -1);
5        return solver(nums , 0 , dp);
6    }
7    public int solver(int[] arr , int i , int[] dp){
8        if(i >= arr.length) return 0;
9        if(dp[i] != -1) return dp[i];
10
11        int x = arr[i] + solver(arr , i+2 , dp);
12        int y = solver(arr , i+1 , dp);
13        return dp[i] = Math.max(x,y);
14    }
15}