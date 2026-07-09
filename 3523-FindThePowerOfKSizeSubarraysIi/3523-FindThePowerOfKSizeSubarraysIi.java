// Last updated: 7/9/2026, 5:04:40 PM
class Solution {
    public int[] resultsArray(int[] nums, int k) {
        int n = nums.length;
        int[] ans = new int[n - k + 1];
        int c = 0;
        for(int i = 1 ; i < k ; i++){
            if(nums[i] == nums[i-1]+1){
                c++;
            }
        }
        ans[0] = (c == k-1) ? nums[k-1] : -1;
        for(int i = k ; i < n ; i++){
            if(nums[i-k+1] == nums[i-k]+1){
                c--;
            }

            if(nums[i] == nums[i-1]+1){
                c++;
            }

            ans[i-k+1] = (c == k-1) ? nums[i] : -1;
        }
        return ans;
    }
}