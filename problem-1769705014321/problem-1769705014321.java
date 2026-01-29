// Last updated: 1/29/2026, 10:13:34 PM
1class Solution {
2    public int maxFrequency(int[] nums, int k) {
3       
4        int[][] frq = new int[50][];
5        int cntK = 0, max = 1;
6        for(int i = 0; i < nums.length; i++){
7            if(nums[i] == k){cntK++;continue;}
8            int[] curr = frq[nums[i] - 1];
9            if(curr == null || curr[0] == -100 || (curr != null && (curr[0] - (cntK - curr[1]) <= 0))) {
10                frq[nums[i] - 1] = new int[]{1, cntK, 1};
11
12            }else{
13                curr[0]++;curr[2] = curr[0] - (cntK - curr[1]);
14                if( curr[2] > max ){
15                    max = curr[2];
16                }
17                
18                if(curr[2] <= 0){curr[0] = -100;}
19            }
20       }
21       return (max + cntK > nums.length) ? nums.length : max + cntK;
22    }
23}