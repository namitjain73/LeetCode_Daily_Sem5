// Last updated: 1/3/2026, 1:06:50 PM
1class Solution {
2    public boolean canPartition(int[] nums) {
3        int sum  = 0;
4        for(int i : nums) sum += i;
5        if(sum % 2 != 0) return false;
6        int dp[][] = new int[nums.length][sum+1];
7        for(int[] d : dp) Arrays.fill(d , -1);
8        return solver(nums , sum/2 , 0 ,0,dp);
9        
10    }
11
12    public static boolean solver(int[] arr , int sum , int ans ,int idx,int[][] dp){
13        if(idx == arr.length) return false;
14        if(sum == ans) return true;
15        if(dp[idx][ans] != -1) return dp[idx][ans] == 1 ? true : false;
16
17        boolean skip = solver(arr , sum , ans , idx+1,dp);
18        boolean take = false;
19        if(sum >= ans){
20            take = solver(arr , sum , ans + arr[idx], idx+1,dp);
21        }
22
23        if(skip || take){
24            dp[idx][ans] = 1;
25        }else dp[idx][ans] = 0;
26        return skip || take;
27    }
28}