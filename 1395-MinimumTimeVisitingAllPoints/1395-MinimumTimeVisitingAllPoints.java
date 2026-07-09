// Last updated: 7/9/2026, 5:17:13 PM
class Solution {
    public int minTimeToVisitAllPoints(int[][] points) {
        int ans = 0;
        int[] pre = points[0];
        for(int i = 1 ; i < points.length ; i++){
            int diff = Math.abs(pre[0]-points[i][0]);
            diff = Math.max(diff, Math.abs(pre[1] - points[i][1]));
            ans += diff;
            pre = points[i];
        }
        return ans;
    }
}