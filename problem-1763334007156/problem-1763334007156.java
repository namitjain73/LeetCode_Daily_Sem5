// Last updated: 11/17/2025, 4:30:07 AM
class Solution {
    public int partitionArray(int[] nums, int k) {
        Arrays.sort(nums);
        int lo = nums[0];
        int res=0;
        for(int i = 1 ;i <= nums.length ; i++){
            if(i == nums.length || nums[i] - lo > k){
                res++;
                lo = i == nums.length ? 0 : nums[i];
            }
        }
        return res;
    }
}