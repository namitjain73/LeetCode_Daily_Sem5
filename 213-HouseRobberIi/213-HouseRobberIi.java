// Last updated: 7/9/2026, 5:23:16 PM
class Solution {
    public int rob(int[] nums) {
        if(nums.length == 1) return nums[0];
        int[] arr1 = new int[nums.length-1];
        int[] arr2 = new int[nums.length-1];

        for(int i = 0 ; i < nums.length-1 ; i++){
            arr1[i] = nums[i];
        }

        for(int i = 1 ; i < nums.length ; i++){
            arr2[i-1] = nums[i];
        }

        return Math.max(solve(arr1),solve(arr2));
        
    }

    public int solve(int [] nums){
        int n = nums.length;

        if(n == 0) return 0;
        if(n == 1) return nums[0];
        
        int[] dp = new int[n];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0],nums[1]);

        for(int i = 2 ; i < n ; i++){
            int incl = dp[i - 2] + nums[i];
            int exc = dp[i-1];
            dp[i] = Math.max(incl,exc);
        }

        return dp[n-1];
    }
}