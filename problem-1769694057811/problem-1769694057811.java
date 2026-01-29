// Last updated: 1/29/2026, 7:10:57 PM
1class Solution {
2    int[][] dp;
3
4    public int maxProfit(int[] prices) {
5        int n = prices.length;
6        dp = new int[n][2];
7        for (int i = 0; i < n; i++) {
8            Arrays.fill(dp[i], -1);
9        }
10        return solve(prices, 0, 1);
11    }
12
13    public int solve(int[] prices, int idx, int canBuy) {
14        if (idx == prices.length) return 0;
15
16        if (dp[idx][canBuy] != -1) return dp[idx][canBuy];
17
18        int ans;
19        if (canBuy == 1) {
20            // buy or skip
21            ans = Math.max(-prices[idx] + solve(prices, idx + 1, 0),solve(prices, idx + 1, 1));
22        } else {
23            // sell or skip
24            ans = Math.max(prices[idx] + solve(prices, idx + 1, 1),solve(prices, idx + 1, 0));
25        }
26
27        return dp[idx][canBuy] = ans;
28    }
29}
30