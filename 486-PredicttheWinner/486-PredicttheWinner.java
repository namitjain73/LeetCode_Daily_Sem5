// Last updated: 10/16/2025, 2:27:23 AM
class Solution {
    public boolean predictTheWinner(int[] nums) {
        if(nums.length <  2) return true;
        int sum = 0;
        for(int i : nums) sum += i;
        int[][] dp = new int[nums.length][nums.length];
        for(int[] d : dp) Arrays.fill(d,-1);
        int ans = solver(nums,0,nums.length-1,dp);
        if((sum-ans) > ans) return false;
        return true;
    }
    public int solver(int[] arr ,int i , int j ,int[][] dp){
        if(i > j) return 0;
        if(dp[i][j] != -1) return dp[i][j];
        int f = arr[i] + Math.min(solver(arr,i+2,j,dp),solver(arr,i+1,j-1,dp));
        int l = arr[j] + Math.min(solver(arr,i+1,j-1,dp),solver(arr,i,j-2,dp));
        return dp[i][j] = Math.max(f,l);
    }
}
