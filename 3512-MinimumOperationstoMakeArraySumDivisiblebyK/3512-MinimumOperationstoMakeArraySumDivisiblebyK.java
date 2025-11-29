// Last updated: 11/30/2025, 3:12:55 AM
1class Solution {
2    public int minOperations(int[] nums, int k) {
3        int sum = 0;
4        for(int i : nums) sum += i;
5        return sum % k;
6    }
7}