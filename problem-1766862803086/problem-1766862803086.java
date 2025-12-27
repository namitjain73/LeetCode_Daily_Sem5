// Last updated: 12/28/2025, 12:43:23 AM
1class Solution {
2    public int minimumSubarrayLength(int[] nums, int k) {
3        int n = nums.length;
4        int len = n+1;
5
6        for(int i = 0 ;  i < n ; i++){
7            int val = 0;
8            for(int j = i ; j < n; j++){
9                val |= nums[j];
10                if(val >= k){
11                    len = Math.min(len , j - i + 1);
12                }
13            }
14        }
15        return len == n+1 ? -1 : len;
16    }
17}