// Last updated: 1/14/2026, 11:18:30 PM
1class Solution {
2    public int maxOperations(int[] nums) {
3        int n = nums.length;
4        int ans = 0;
5        int[][] dp = new int[n][n];
6        for(int[] d : dp) Arrays.fill(d , -1);
7        ans = Math.max(ans,solver(nums , 2 , n-1 , nums[0]+nums[1],dp)+1);
8        dp = new int[n][n];
9        for(int[] d : dp) Arrays.fill(d , -1);
10        ans = Math.max(ans,solver(nums , 0 , n-3 , nums[n-1]+nums[n-2],dp)+1);
11        dp = new int[n][n];
12        for(int[] d : dp) Arrays.fill(d , -1);
13        ans = Math.max(ans,solver(nums, 1 , n-2 , nums[0]+nums[n-1],dp)+1);
14        return ans;
15    }
16    public int solver(int[] nums , int i , int j ,int n,int[][] dp){
17        // System.out.println(n+" "+i+" "+j);
18        if(i >= j) return 0;
19        if(dp[i][j] != -1) return dp[i][j];
20        
21
22        int ans = 0;
23        if((i+1) <= (j) && nums[i] + nums[i+1] == n) ans = Math.max(ans,solver(nums , i+2 , j , n,dp) + 1);
24        if(i <= (j-1) && nums[j] + nums[j-1] == n) ans = Math.max(ans,solver(nums , i , j-2, n,dp) + 1);
25        if(nums[i] + nums[j] == n) ans = Math.max(ans,solver(nums , i+1 , j-1 , n,dp) + 1);
26        return dp[i][j] = ans;
27    }
28}