// Last updated: 1/19/2026, 12:35:16 AM
1class Solution {
2    public int missingNumber(int[] nums) {
3        int ans = 0;
4        for(int i = 0 ; i < nums.length; i++){
5            ans ^= (i+1);
6            ans ^= nums[i];
7        }
8        return ans;
9    }
10}