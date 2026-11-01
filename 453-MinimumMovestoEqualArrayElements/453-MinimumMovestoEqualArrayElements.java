// Last updated: 11/1/2026, 5:05:59 PM
1class Solution {
2    public int minMoves(int[] nums) {
3        int sum=0;
4        Arrays.sort(nums);
5        for(int i : nums){
6            sum += i - nums[0];
7        }
8        return sum;
9    }
10}