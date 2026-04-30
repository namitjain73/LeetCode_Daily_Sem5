// Last updated: 4/30/2026, 11:22:53 AM
1import java.util.*;
2
3class Solution {
4    public long maximumScore(int[][] A) {
5        int n = A.length;
6
7        long[][] B = new long[n][n + 1];
8        for (int j = 0; j < n; j++) {
9            for (int i = 0; i < n; i++) {
10                B[j][i + 1] = B[j][i] + A[i][j];
11            } 
12        }
13
14        long[] pdp = new long[n + 1];
15        long[] pep = new long[n + 1];
16
17        for (int j = 1; j < n; j++) {
18            long[] dp = new long[n + 1];
19            long[] ep = new long[n + 1];
20
21            for (int pb = 0; pb <= n; pb++) {
22                for (int cb = 0; cb <= n; cb++) {
23
24                    long pv = 0;
25                    if (cb > pb) {
26                        pv = B[j - 1][cb] - B[j - 1][pb];
27                    }
28
29                    long cv = 0;
30                    if (cb < pb) {
31                        cv = B[j][pb] - B[j][cb];
32                    }
33
34                    dp[cb] = Math.max(dp[cb],
35                            Math.max(pv + pdp[pb], pep[pb])
36                    );
37
38                    ep[cb] = Math.max(ep[cb],
39                            Math.max(cv + pep[pb],
40                                     cv + pv + pdp[pb])
41                    );
42                }
43            }
44
45            pdp = dp;
46            pep = ep;
47        }
48
49        long ans = 0;
50        for (long v : pep) {
51            ans = Math.max(ans, v);
52        }
53
54        return ans;
55    }
56}    