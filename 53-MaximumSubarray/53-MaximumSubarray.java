// Last updated: 7/9/2026, 5:25:18 PM
class Solution {
    public int maxSubArray(int[] nums) {
        int sum = 0;
        int ans = Integer.MIN_VALUE;
        for(int i = 0 ; i < nums.length ; i++){
            sum += nums[i];
            ans = Math.max(sum,ans);
            if(sum < 0) sum = 0;
        }
        return ans;
    }
}