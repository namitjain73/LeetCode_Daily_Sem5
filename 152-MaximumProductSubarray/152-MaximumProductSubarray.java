// Last updated: 7/9/2026, 5:23:52 PM
class Solution {
    public int maxProduct(int[] nums) {
        int max = nums[0];
        int ans = 1;
        for(int i = 0 ; i < nums.length ; i ++){
            ans = 1;
            for(int j = i ; j < nums.length ; j++){
                ans *= nums[j];
                max = Math.max(ans,max);
            }
        }
        return max;
        
    }
}