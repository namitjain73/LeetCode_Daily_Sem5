// Last updated: 3/10/2026, 11:54:23 PM
1
2
3class Solution {
4    int MOD = 1_000_000_007;
5
6    public int numberOfStableArrays(int zero, int one, int limit) {
7        int[][][] dp = new int[zero + 1][one + 1][2];
8        for (int i = 1; i <= Math.min(zero, limit); i++){
9            dp[i][0][0] = 1;
10        }
11        for (int i = 1; i <= Math.min(one, limit); i++){
12            dp[0][i][1] = 1;
13        }
14
15
16        for (int i = 1; i <= zero; i++) {
17            for (int j = 1; j <= one; j++) {
18                dp[i][j][0] = (dp[i - 1][j][0] + dp[i - 1][j][1]) % MOD;
19                if (i > limit){
20                    dp[i][j][0] = (dp[i][j][0] + MOD - dp[i - limit - 1][j][1]) % MOD;
21                }
22                
23                dp[i][j][1] = (dp[i][j - 1][0] + dp[i][j - 1][1]) % MOD;
24                if (j > limit){
25                    dp[i][j][1] = (dp[i][j][1] + MOD - dp[i][j - limit - 1][0]) % MOD;
26                }
27            }
28        }
29        return (dp[zero][one][0] + dp[zero][one][1]) % MOD;
30    }
31}