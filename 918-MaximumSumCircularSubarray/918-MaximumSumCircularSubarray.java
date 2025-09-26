// Last updated: 9/26/2025, 1:39:09 PM
class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        // System.out.println(min(nums));
        int min = min(nums);
        int total = 0;
        int max = max(nums);
        for(int i : nums ) total += i;
        if(min == total) return max;

        return Math.max(total - min,max);
    }
    public int min(int[] nums){
        int min = Integer.MAX_VALUE;
        int sum  = 0;

        for(int i = 0 ; i < nums.length ; i++){
            sum += nums[i];
            min = Math.min(min,sum);
            if(sum > 0){
                sum = 0;
            }
        }
        return min;
    }

    public int max(int[] nums){
        int min = Integer.MIN_VALUE;
        int sum  = 0;

        for(int i = 0 ; i < nums.length ; i++){
            sum += nums[i];
            min = Math.max(min,sum);
            if(sum < 0){
                sum = 0;
            }
        }
        return min;
    }
}