// Last updated: 9/30/2025, 8:00:15 PM
class Solution {
    public int longestOnes(int[] nums, int k) {
        int ans = 0;
        int l = 0;
        int zero = 0;
        for(int r = 0 ; r < nums.length ; r++){
            if(nums[r] == 0) zero++;

            while(zero > k){
                if(nums[l] == 0) zero--;
                l++;
            }

            ans = Math.max(ans,r-l+1);
        }
        return ans;
        
    }
}