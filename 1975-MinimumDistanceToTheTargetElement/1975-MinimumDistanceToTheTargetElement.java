// Last updated: 7/9/2026, 5:14:09 PM
class Solution {
    public int getMinDistance(int[] nums, int t, int start) {
        int n = nums.length;
        int ans = Integer.MAX_VALUE;
        int i = start;
        while(i < n){
            if(nums[i] == t){
                ans = i - start;
                break;
            }
            i++;
        }
        i = start;
        while(i >= 0){
            if(nums[i] == t)ans = Math.min(ans,start - i);
            i--;
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}