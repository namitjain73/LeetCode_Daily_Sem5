// Last updated: 11/8/2025, 9:10:09 PM
class Solution {
    public int longestSubarray(int[] nums) {
        int n = nums.length;
        if(n==1) return 1;
        int[] left = new int[n];
        int[] right = new int[n];
        left[0] = 1;
        for(int i = 1 ; i < n ; i++){
            if(nums[i] >= nums[i-1]){
                left[i] = left[i-1]+1;
            }else left[i] =  1;
        }

        right[n-1]= 1;
        for(int i  = n-2 ; i >= 0 ; i--){
            if(nums[i] <= nums[i+1]){
                right[i] = right[i+1]+1;
            }else right[i] = 1;
        }

        int ans = 1;
        for(int i = 0 ; i < n ; i++){
            ans = Math.max(ans , Math.max(left[i],right[i]));
        }

        for(int i = 0 ; i < n ; i++){
            int leftlen = (i > 0) ? left[i-1] : 0;
            int rightlen = (i < n-1) ? right[i+1] : 0;

            int res;
            if((i > 0 ) && i < n-1 && nums[i-1] <= nums[i+1]){
                res = leftlen + rightlen + 1;
            }else{
                res = Math.max(leftlen+1 , rightlen+1);
            }
            res = Math.min(res,n);
            ans = Math.max(res,ans);
        }
        return ans;
    }
}