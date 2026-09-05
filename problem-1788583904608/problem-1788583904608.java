// Last updated: 9/5/2026, 10:21:44 AM
1class Solution {
2    public int firstStableIndex(int[] nums, int k) {
3        int n = nums.length;
4        int[] pre  = new int[n];
5        pre[n-1] = nums[n-1];
6
7        for(int i = n-2 ; i >=0 ; i--){
8            pre[i] = Math.min(pre[i+1] , nums[i]);
9        }
10        int max = -1;
11        int ans = Integer.MAX_VALUE;
12        for(int i = 0 ; i  < n ; i++){
13            max = Math.max(max , nums[i]);
14            if(max - pre[i] <= k){
15                ans = Math.min(ans , i);
16            }
17        }
18        return ans == Integer.MAX_VALUE ? -1 : ans;
19    }
20}