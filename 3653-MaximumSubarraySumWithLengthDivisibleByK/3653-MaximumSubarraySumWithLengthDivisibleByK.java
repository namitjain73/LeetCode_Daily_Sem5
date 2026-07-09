// Last updated: 7/9/2026, 5:03:10 PM
class Solution {
    public long maxSubarraySum(int[] nums, int k) {
        long res = Long.MIN_VALUE;
        int n = nums.length;
        long[] pre = new long[n];
        pre[0] = nums[0];
        for(int i = 1 ; i < n ; i++){
            pre[i] = pre[i-1] + nums[i];
        }

        for(int start = 0 ; start < k ; start++){
            long curr = 0;
            int i = start;
            while(i < n && i+k-1 < n){
                int j = i+k-1;
                long sum = pre[j]  - (i <= 0 ? 0 : pre[i-1]);
                curr = Math.max(sum , sum+curr);
                res = Math.max(res,curr);
                i+=k;
            }
        }
        return res;
    }
}