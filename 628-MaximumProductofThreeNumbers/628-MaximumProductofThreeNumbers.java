// Last updated: 7/26/2026, 10:26:56 PM
1class Solution {
2    public int maximumProduct(int[] nums) {
3        Arrays.sort(nums);
4        int n = nums.length;
5        int mul1 = nums[n-1] * nums[n- 2] * nums[n - 3];
6        int mul2 = nums[0]*nums[1]*nums[2];
7        int mul3 = nums[0]*nums[1]*nums[n-1];
8        return Math.max(mul1 , Math.max(mul2,mul3));
9    }
10}