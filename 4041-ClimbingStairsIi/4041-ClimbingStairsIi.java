// Last updated: 7/9/2026, 4:58:43 PM
class Solution {
    public int climbStairs(int n, int[] costs) {
        int[] dp = new int[n + 1];
        dp[0] = 0;
        for (int j = 1; j <= n; j++) {
            dp[j] = Integer.MAX_VALUE;
            for (int k = 1; k <= 3; k++) {
                int pre = j - k;
                if (pre >= 0) {
                    int jump = costs[j - 1] + k * k; 
                    if (dp[pre] != Integer.MAX_VALUE) {
                        int total = dp[pre] + jump;
                        dp[j] = Math.min(dp[j], total);
                    }
                }
            }
        }
        return dp[n];
    }
}