// Last updated: 7/9/2026, 5:23:50 PM
class Solution {
    public int findMin(int[] nums) {
        int n=nums.length;
        for(int i=0;i<n-1;i++)
        {
            if(nums[i]>nums[i+1])
            {
                return nums[i+1];
            }
        }
        return nums[0];
    }
}