// Last updated: 7/9/2026, 5:13:38 PM
class Solution {
    public int[] getConcatenation(int[] nums) {
        int n = nums.length;
        int[] ans= new int[n+n];
        for(int i = 0 ; i < n ; i++){
            ans[i] = nums[i];
            ans[i+n] = nums[i];
        }
        return ans;
    }
}