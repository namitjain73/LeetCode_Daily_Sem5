// Last updated: 7/9/2026, 5:18:28 PM
class Solution {
    public int[] sortedSquares(int[] nums) {
        for(int i = 0 ; i < nums.length ; i++){
            nums[i] = nums[i]*nums[i];
        }
                Arrays.sort(nums);

        return nums;
        
    }
}