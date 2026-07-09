// Last updated: 7/9/2026, 5:04:47 PM
class Solution {
    public int maximumLength(int[] nums, int k) {
        int[][] dp = new int[nums.length][k];
        for(int[] dpin : dp) Arrays.fill(dpin,1);

        int max=0;
        for(int i=0 ; i<nums.length ; i++){
            for(int j=i-1 ; j>=0 ; j--){
                int rem = (nums[i]+nums[j])%k;
                dp[i][rem] = Math.max(dp[i][rem],dp[j][rem]+1);
                max = Math.max(max,dp[i][rem]);
            }
        }
        return max;
    }
}