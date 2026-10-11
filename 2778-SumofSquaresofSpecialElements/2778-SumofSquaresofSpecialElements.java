// Last updated: 10/11/2026, 9:57:49 PM
1class Solution {
2    public int sumOfSquares(int[] nums) {
3        int n = nums.length;
4        int ans = 0;
5        for(int i = 0 ; i < n ; i++){
6            if(n % (i+1) == 0) ans += nums[i] * nums[i];
7        }
8        return ans;
9    }
10}