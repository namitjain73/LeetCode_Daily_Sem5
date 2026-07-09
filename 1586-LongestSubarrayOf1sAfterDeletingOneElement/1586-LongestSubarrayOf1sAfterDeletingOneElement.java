// Last updated: 7/9/2026, 5:16:01 PM
class Solution {
    public int longestSubarray(int[] nums) {
        int max = 0;
        int i =0;
        int zero  = 0;
        int j=0;
        int n = nums.length;

        while(j < n){
            if(nums[j] == 0) zero++;
            while(zero > 1){
                if(nums[i] == 0) zero--;
                i++;
            }

            max = Math.max(max , j-i);
            j++;
        }
        return max;
    }
}