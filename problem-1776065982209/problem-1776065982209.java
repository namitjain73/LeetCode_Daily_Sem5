// Last updated: 4/13/2026, 1:09:42 PM
1class Solution {
2    public int getMinDistance(int[] nums, int t, int start) {
3        int n = nums.length;
4        int ans = Integer.MAX_VALUE;
5        int i = start;
6        while(i < n){
7            if(nums[i] == t){
8                ans = i - start;
9                break;
10            }
11            i++;
12        }
13        i = start;
14        while(i >= 0){
15            if(nums[i] == t)ans = Math.min(ans,start - i);
16            i--;
17        }
18        return ans == Integer.MAX_VALUE ? -1 : ans;
19    }
20}