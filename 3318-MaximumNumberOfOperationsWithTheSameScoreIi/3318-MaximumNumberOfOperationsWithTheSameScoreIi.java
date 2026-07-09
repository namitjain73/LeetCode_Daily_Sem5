// Last updated: 7/9/2026, 5:05:56 PM
class Solution {
    public int maxOperations(int[] nums) {
        int n = nums.length;
        int ans = 0;
        int[][] dp = new int[n][n];
        for(int[] d : dp) Arrays.fill(d , -1);
        ans = Math.max(ans,solver(nums , 2 , n-1 , nums[0]+nums[1],dp)+1);
        dp = new int[n][n];
        for(int[] d : dp) Arrays.fill(d , -1);
        ans = Math.max(ans,solver(nums , 0 , n-3 , nums[n-1]+nums[n-2],dp)+1);
        dp = new int[n][n];
        for(int[] d : dp) Arrays.fill(d , -1);
        ans = Math.max(ans,solver(nums, 1 , n-2 , nums[0]+nums[n-1],dp)+1);
        return ans;
    }
    public int solver(int[] nums , int i , int j ,int n,int[][] dp){
        // System.out.println(n+" "+i+" "+j);
        if(i >= j) return 0;
        if(dp[i][j] != -1) return dp[i][j];
        

        int ans = 0;
        if((i+1) <= (j) && nums[i] + nums[i+1] == n) ans = Math.max(ans,solver(nums , i+2 , j , n,dp) + 1);
        if(i <= (j-1) && nums[j] + nums[j-1] == n) ans = Math.max(ans,solver(nums , i , j-2, n,dp) + 1);
        if(nums[i] + nums[j] == n) ans = Math.max(ans,solver(nums , i+1 , j-1 , n,dp) + 1);
        return dp[i][j] = ans;
    }
}