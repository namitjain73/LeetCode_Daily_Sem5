// Last updated: 7/31/2026, 10:37:05 PM
1class Solution {
2    public int findGCD(int[] nums) {
3        Arrays.sort(nums);
4        int max = 0;
5        for(int i = 1 ; i <= nums[nums.length-1] ; i++){
6            if(nums[0] % i == 0 && nums[nums.length-1] % i == 0){
7                max = Math.max(max,i);
8            }
9        }
10        return max;
11        
12    }
13}