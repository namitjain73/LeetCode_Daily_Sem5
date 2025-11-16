// Last updated: 11/16/2025, 9:40:50 PM
class Solution {
    public long minCost(int[] nums, int[] cost) {
        int n = nums.length;
        long ans = Integer.MAX_VALUE;
        int lo = Integer.MAX_VALUE;
        int hi = Integer.MIN_VALUE;
        for(int i = 0 ; i < n ; i++){
            lo = Math.min(lo , nums[i]);
            hi = Math.max(hi , nums[i]);
        }
        while(lo <= hi){
            int mid = lo + (hi - lo)/2;
            long midsum = sum(mid , nums , cost);
            long midone = sum(mid+1 , nums , cost);
            ans = Math.min(midsum,midone);
            if(midsum < midone){
                hi = mid - 1;
            }else{
                lo = mid + 1;
            }
        }
        return ans;
    }
    public long sum(int t , int[] arr ,int[] cost){
        long sum = 0;
        int n = arr.length;
        for(int i =0 ; i < n ; i++){
            sum = sum + (long)Math.abs(arr[i]-t)*cost[i];
        }
        return sum;
    }
}