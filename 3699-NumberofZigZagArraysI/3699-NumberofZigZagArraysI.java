// Last updated: 6/24/2026, 1:17:19 AM
1class Solution {
2    private static final int MOD = 1000000007;
3
4    public int zigZagArrays(int n, int l, int r) {
5        int m = r - l + 1;
6
7        int[] dp = new int[m];
8        java.util.Arrays.fill(dp, 1);
9
10        for (int len = 2; len <= n; len++) {
11
12            if ((len & 1) == 0) {
13                long pref = 0;
14
15                for (int i = 0; i < m; i++) {
16                    int old = dp[i];
17
18                    dp[i] = (int) pref;
19
20                    pref = (pref + old) % MOD;
21                }
22            }
23            else {
24                long suff = 0;
25
26                for (int i = m - 1; i >= 0; i--) {
27                    int old = dp[i];
28
29                    dp[i] = (int) suff;
30
31                    suff = (suff + old) % MOD;
32                }
33            }
34        }
35
36        long ans = 0;
37
38        for (int x : dp) {
39            ans = (ans + x) % MOD;
40        }
41
42        return (int) ((ans * 2) % MOD);
43    }
44}