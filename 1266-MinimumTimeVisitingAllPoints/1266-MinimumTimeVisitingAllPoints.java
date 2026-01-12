// Last updated: 1/13/2026, 12:42:12 AM
1class Solution {
2    public int minTimeToVisitAllPoints(int[][] points) {
3        int ans = 0;
4        int[] pre = points[0];
5        for(int i = 1 ; i < points.length ; i++){
6            int diff = Math.abs(pre[0]-points[i][0]);
7            diff = Math.max(diff, Math.abs(pre[1] - points[i][1]));
8            ans += diff;
9            pre = points[i];
10        }
11        return ans;
12    }
13}