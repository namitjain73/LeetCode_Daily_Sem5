// Last updated: 12/5/2025, 11:14:44 PM
1class Solution {
2    public int[] getConcatenation(int[] nums) {
3        int n = nums.length;
4        int[] ans= new int[n+n];
5        for(int i = 0 ; i < n ; i++){
6            ans[i] = nums[i];
7            ans[i+n] = nums[i];
8        }
9        return ans;
10    }
11}