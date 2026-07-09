// Last updated: 7/9/2026, 4:58:55 PM
class Solution {
    public long splitArray(int[] nums) {
        int n = nums.length;
        long[] suffix = new long[n];
        long[] prefix = new long[n];
        prefix[0] = nums[0];
        for(int i= 1 ; i < n ; i++){
            prefix[i] = prefix[i-1]+nums[i];
        }
        suffix[n-1] = nums[n-1];
        for(int i = n-2 ; i >= 0 ;i--){
            suffix[i] = suffix[i+1] + nums[i];
        }

        boolean[] pre = new boolean[n];
        boolean[] suf = new boolean[n];
        pre[0] = true;
        suf[n-1] = true;
        for(int i = 1 ; i < n ; i++){
            if(nums[i-1] < nums[i] && pre[i-1] == true){
                pre[i] = true;
            }
        }

        for(int i = n-2 ; i >=0 ; i--){
    if(nums[i] > nums[i+1] && suf[i+1] == true){ // CORRECT: strictly greater
        suf[i] = true;
    }
}

        long ans = Long.MAX_VALUE;
        for(int i = 0 ; i < n-1 ; i++){
            if(pre[i] == true && suf[i+1] ==true){
                ans = Math.min(ans,Math.abs(prefix[i]-suffix[i+1]));
            }
        }
        return ans == Long.MAX_VALUE ? -1 : ans;
        
    }
}