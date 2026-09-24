// Last updated: 9/24/2026, 9:09:46 PM
1class Solution {
2    public int smallestIndex(int[] nums) {
3        for(int i = 0 ; i < nums.length ; i++){
4            int sum = 0;
5            while(nums[i] > 0){
6                int rem = nums[i] % 10;
7                sum += rem;
8                nums[i] = nums[i] / 10;
9            }
10            if(i == sum) return i;
11        }
12        return -1;
13    }
14}