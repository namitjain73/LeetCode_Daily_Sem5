// Last updated: 7/9/2026, 5:18:43 PM
class Solution {
    public int minIncrementForUnique(int[] nums) {
        Arrays.sort(nums);
        int ans = 0;
        for(int i = 1 ; i < nums.length ; i++){
            if(nums[i-1] >= nums[i]){
                ans += 1 + nums[i-1] - nums[i];
                nums[i] = nums[i-1]+1;
            }
        }
        return ans;
    }
}