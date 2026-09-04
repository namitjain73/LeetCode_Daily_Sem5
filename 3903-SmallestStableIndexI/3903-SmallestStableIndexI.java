// Last updated: 9/4/2026, 11:25:45 PM
1class Solution {
2    public int firstStableIndex(int[] nums, int k) {
3        int n = nums.length;
4        int[] pre = new int[n];
5        pre[n-1] = nums[n-1];
6        for(int i = n-2 ; i >= 0 ; i--){
7            pre[i] = Math.min(pre[i+1] , nums[i]);
8        }
9
10        int ans = Integer.MAX_VALUE;
11        int max = -1;
12
13        for(int i = 0 ; i < n ; i++){
14            max = Math.max(max , nums[i]);
15
16            if(max - pre[i] <= k) ans = Math.min(ans , i);
17        }
18        return ans == Integer.MAX_VALUE ? -1 : ans;
19
20    }
21}