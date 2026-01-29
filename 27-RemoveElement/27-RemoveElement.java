// Last updated: 1/29/2026, 5:57:57 PM
1class Solution {
2    public int removeElement(int[] nums, int val) {
3        int idx = 0;
4        for(int i = 0 ; i < nums.length ; i++){
5            if(nums[i] == val) continue;
6            nums[idx] = nums[i];
7            idx++;
8        }
9        return idx;
10    }
11}