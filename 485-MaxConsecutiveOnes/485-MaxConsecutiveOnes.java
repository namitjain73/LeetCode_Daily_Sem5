// Last updated: 7/9/2026, 5:21:21 PM
class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int res = 0;
        int n = nums.length;
        int ans = 0;

        for(int i = 0 ; i < n ;i++){
            if(nums[i] == 1){
                ans++;
            }
            else if(nums[i] == 0){
                res = Math.max(res,ans);
                ans = 0;
            }
        }
        return Math.max(ans,res);
    }
}