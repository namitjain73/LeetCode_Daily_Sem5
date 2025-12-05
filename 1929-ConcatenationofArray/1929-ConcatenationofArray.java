// Last updated: 12/5/2025, 11:23:44 PM
1class Solution {
2    public int[] shuffle(int[] nums, int n) {
3        int[] ans = new int[2*n];
4        int j = 0;
5        for(int i = 0 ; i < 2*n ; i+=2){
6            //System.out.println(i);
7            ans[i] = nums[j];
8            ans[i+1] = nums[j+n];
9            j++;
10        }
11        return ans;
12    }
13}