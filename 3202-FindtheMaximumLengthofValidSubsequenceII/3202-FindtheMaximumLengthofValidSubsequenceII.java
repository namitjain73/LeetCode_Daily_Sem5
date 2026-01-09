// Last updated: 1/9/2026, 11:42:17 PM
1class Solution {
2    public int maximumLength(int[] nums, int k) {
3        int[][] dp = new int[nums.length][k];
4        for(int[] dpin : dp) Arrays.fill(dpin,1);
5
6        int max=0;
7        for(int i=0 ; i<nums.length ; i++){
8            for(int j=i-1 ; j>=0 ; j--){
9                int rem = (nums[i]+nums[j])%k;
10                dp[i][rem] = Math.max(dp[i][rem],dp[j][rem]+1);
11                max = Math.max(max,dp[i][rem]);
12            }
13        }
14        return max;
15    }
16}