// Last updated: 6/10/2026, 11:07:01 AM
1class Solution {
2    public long maxTotalValue(int[] nums, int k) {
3        int  min =Integer.MAX_VALUE;
4        int max= Integer.MIN_VALUE;
5        for(int i : nums){
6            min = Math.min(min,i);
7            max = Math.max(max,i);
8        }
9
10        return (long)((long)max - (long)min) * (long)k;
11    }
12}