// Last updated: 8/25/2026, 9:17:52 AM
1class Solution {
2    public int missingMultiple(int[] nums, int k) {
3        Arrays.sort(nums);
4        int j = 2;
5        int num = k;
6        for(int i = 0 ; i < nums.length ; i++){
7            if(nums[i] == k) {
8                k = num*j;
9                j++;
10            }
11            else if(nums[i] > k) return k;
12        }
13        return k;
14    }
15}