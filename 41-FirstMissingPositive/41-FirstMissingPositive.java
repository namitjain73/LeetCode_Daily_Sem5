// Last updated: 7/9/2026, 5:25:33 PM
class Solution {
    public int firstMissingPositive(int[] nums) {
        Arrays.sort(nums);
        int j = 1;
        for(int i = 0 ; i < nums.length ; i++){
            if(j < nums[i]) return j;
            else if(nums[i] < 1) continue;
            else if(j == nums[i]) j++;
        }
        return j;
    }
}