// Last updated: 12/5/2025, 11:26:07 PM
1class Solution {
2    public int findMaxConsecutiveOnes(int[] nums) {
3        int res = 0;
4        int n = nums.length;
5        int ans = 0;
6
7        for(int i = 0 ; i < n ;i++){
8            if(nums[i] == 1){
9                ans++;
10            }
11            else if(nums[i] == 0){
12                res = Math.max(res,ans);
13                ans = 0;
14            }
15        }
16        return Math.max(ans,res);
17    }
18}