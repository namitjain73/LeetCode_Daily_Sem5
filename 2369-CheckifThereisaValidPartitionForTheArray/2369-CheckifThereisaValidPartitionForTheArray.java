// Last updated: 1/7/2026, 11:10:43 PM
1class Solution {
2    public boolean validPartition(int[] nums) {
3        Boolean[] dp = new Boolean[nums.length];
4        return solver(nums , 0 , nums.length,dp);
5    }
6    public boolean solver(int[] nums , int idx , int n, Boolean[] dp){
7        if(idx >= n){
8            return true;
9        }
10
11        if(dp[idx] != null) return dp[idx];
12
13        boolean ans = false;
14        if(idx < n-1 && nums[idx] == nums[idx+1]){
15            ans |= solver(nums , idx+2 , n,dp);
16        }
17
18        if(!ans && idx < n-2 && nums[idx] == nums[idx+1]-1 && nums[idx+1]-1 == nums[idx+2]-2){
19            ans |= solver(nums , idx+3 , n,dp);
20        }
21
22        if(!ans && idx < n-2 && nums[idx] == nums[idx+1] && nums[idx+1] == nums[idx+2]){
23            ans |= solver(nums , idx+3 , n,dp); 
24            if(ans) return ans;
25        }
26        return dp[idx] = ans;
27    }
28}