// Last updated: 7/9/2026, 5:21:28 PM
class Solution {
    public int minMoves(int[] nums) {
        int n = 0;
        Arrays.sort(nums);
        for(int i = 0 ; i < nums.length ; i++){
            n += nums[i] - nums[0];
        }
        return n;
        
    }
}