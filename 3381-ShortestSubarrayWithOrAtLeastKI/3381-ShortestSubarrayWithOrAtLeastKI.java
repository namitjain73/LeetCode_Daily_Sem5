// Last updated: 7/9/2026, 5:05:32 PM
class Solution {
    public int minimumSubarrayLength(int[] nums, int k) {
        int n = nums.length;
        int len = n+1;

        for(int i = 0 ;  i < n ; i++){
            int val = 0;
            for(int j = i ; j < n; j++){
                val |= nums[j];
                if(val >= k){
                    len = Math.min(len , j - i + 1);
                }
            }
        }
        return len == n+1 ? -1 : len;
    }
}