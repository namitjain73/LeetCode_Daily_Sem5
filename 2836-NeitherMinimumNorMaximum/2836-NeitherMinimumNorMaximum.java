// Last updated: 7/9/2026, 5:07:48 PM
class Solution {
    public int findNonMinOrMax(int[] nums) {
        Arrays.sort(nums);
        if(nums.length < 3){
            return -1;
        }
        return nums[nums.length/2];
        
    }
}