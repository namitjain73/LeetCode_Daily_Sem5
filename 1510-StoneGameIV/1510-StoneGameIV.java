// Last updated: 8/10/2026, 11:23:17 PM
1class Solution {
2    public boolean winnerSquareGame(int n) {
3        boolean[] dp = new boolean[n + 1];
4
5        for (int i = 0; i <= n; i++) {
6            if (!dp[i]) {
7                for (int j = 1; i + j * j <= n; j++) {
8                    dp[i + j * j] = true;
9                }
10
11                if (dp[n]) {
12                    return true;
13                }
14            }
15        }
16
17        return false;
18    }
19}