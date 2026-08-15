// Last updated: 8/16/2026, 2:02:57 AM
1class Solution {
2    public int longestSubsequence(int[] nums) {
3        int zero = 0;
4        int nzero = 0;
5        int ans = 0;
6        
7        for(int i = 0 ; i < nums.length ; i++){
8            if(nums[i] == 0) zero++;
9            else nzero++;
10            ans ^= nums[i];
11
12        }
13        if(nzero ==0) return 0;
14        if(ans == 0) return nums.length-1;
15        return nums.length;
16    }
17}