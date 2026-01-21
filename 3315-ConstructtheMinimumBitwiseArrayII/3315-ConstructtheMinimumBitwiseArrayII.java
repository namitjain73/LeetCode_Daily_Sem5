// Last updated: 1/21/2026, 12:39:13 PM
1class Solution {
2    public int[] minBitwiseArray(List<Integer> nums) {
3        int n = nums.size();
4        int[] ans = new int[n];
5        for(int i = 0 ; i < n;  i++){
6            int num = nums.get(i);
7            if((num & 1) == 1){
8                ans[i] = num & ~(((num+1) & ~num) >> 1);
9            }else{
10                ans[i] =-1;
11            }
12        }
13        return ans;
14    }
15}