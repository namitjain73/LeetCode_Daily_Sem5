// Last updated: 7/9/2026, 5:24:13 PM
class Solution {
    int[][] dp;

    public int maxProfit(int[] prices) {
        int n = prices.length;
        dp = new int[n][2];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }
        return solve(prices, 0, 1);
    }

    public int solve(int[] prices, int idx, int canBuy) {
        if (idx == prices.length) return 0;

        if (dp[idx][canBuy] != -1) return dp[idx][canBuy];

        int ans;
        if (canBuy == 1) {
            // buy or skip
            ans = Math.max(-prices[idx] + solve(prices, idx + 1, 0),solve(prices, idx + 1, 1));
        } else {
            // sell or skip
            ans = Math.max(prices[idx] + solve(prices, idx + 1, 1),solve(prices, idx + 1, 0));
        }

        return dp[idx][canBuy] = ans;
    }
}
