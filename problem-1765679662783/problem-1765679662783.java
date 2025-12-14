// Last updated: 12/14/2025, 8:04:22 AM
1class Solution {
2    public int absDifference(int[] nums, int k) {
3        Arrays.sort(nums);
4        int sum1 = 0;
5        int sum2 = 0;
6        int i = 0 ;
7        int j = nums.length-1;
8        while(k-- > 0){
9            sum1 += nums[i++];
10            sum2 += nums[j--];
11        }
12        return Math.abs(sum1 - sum2);
13    }
14}