// Last updated: 10/3/2025, 2:40:23 AM
class Solution {
    public int minSubArrayLen(int t, int[] nums) {
        int ans = Integer.MAX_VALUE;
        int l = 0;
        int sum = 0;
        for(int r = 0; r < nums.length; r++){
            sum += nums[r];
            while(sum >= t){
                if(sum >= t) ans = Math.min(ans,r-l+1);
                sum -= nums[l];
                l++;
            }
            
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }
}