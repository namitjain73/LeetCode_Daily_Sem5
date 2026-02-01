// Last updated: 2/1/2026, 11:01:34 PM
1class Solution {
2    public int minimumCost(int[] nums) {
3        int first = nums[0];
4
5        Arrays.sort(nums, 1, nums.length);
6
7        return first + nums[1] + nums[2];
8    }
9}