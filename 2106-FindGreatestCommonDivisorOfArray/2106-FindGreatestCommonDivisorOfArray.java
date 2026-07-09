// Last updated: 7/9/2026, 5:13:17 PM
class Solution {
    public int findGCD(int[] nums) {
        Arrays.sort(nums);
        int max = 0;
        for(int i = 1 ; i <= nums[nums.length-1] ; i++){
            if(nums[0] % i == 0 && nums[nums.length-1] % i == 0){
                max = Math.max(max,i);
            }
        }
        return max;
        
    }
}