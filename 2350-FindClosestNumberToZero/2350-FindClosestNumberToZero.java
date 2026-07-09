// Last updated: 7/9/2026, 5:10:53 PM
class Solution {
    public int findClosestNumber(int[] nums) {
        int n = Integer.MAX_VALUE;
        int max = 0;
        for(int i = 0 ; i < nums.length ; i++){
            if(Math.abs(nums[i]) < n){
                n = Math.abs(nums[i]);
                max = nums[i];
            }
            if(Math.abs(nums[i]) == n){
                if(max < nums[i]){
                    max = nums[i];
                }
            }
        }
        return max;
    }
}