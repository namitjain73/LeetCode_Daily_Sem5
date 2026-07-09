// Last updated: 7/9/2026, 5:22:06 PM
class Solution {
    int res;
    public int combinationSum4(int[] nums, int target) {
        res= 0;
        int[] dp = new int[target+1];
        Arrays.fill(dp,-1);
        return solver(nums , target,dp);
        // return res;
    }

    public int solver(int[] nums , int t,int[] dp){
        if(t == 0){
            return 1;
        }
        if(dp[t] != -1) return dp[t];
        int n =0;

        for(int i = 0 ; i < nums.length ; i++){
            if(t >= nums[i]){
                // System.out.println(t);
                n +=solver(nums , t - nums[i],dp);
            }
        }
        return dp[t] = n;
    }
}