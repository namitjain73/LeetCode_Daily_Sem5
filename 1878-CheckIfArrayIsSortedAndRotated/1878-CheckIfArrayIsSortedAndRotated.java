// Last updated: 7/9/2026, 5:14:43 PM
class Solution {
    public boolean check(int[] nums) {
        int max = 0;
        if(nums[nums.length-1] > nums[0]) max++;
        for(int i = 1 ; i < nums.length ; i++) if(nums[i-1] > nums[i]) max++;
        return max < 2;
    }
}