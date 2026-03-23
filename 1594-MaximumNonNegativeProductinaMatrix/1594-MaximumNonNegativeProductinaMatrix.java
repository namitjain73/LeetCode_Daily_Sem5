// Last updated: 3/24/2026, 3:38:24 AM
1class Solution {
2    public int maxProductPath(int[][] grid) {
3        int MOD = (int)1e9 + 7;
4        int m = grid.length, n = grid[0].length;
5
6        long[][] min_dp = new long[m][n], max_dp = new long[m][n];
7        min_dp[0][0] = grid[0][0]; 
8        max_dp[0][0] = grid[0][0];
9
10        for (int j = 1; j < n; j++) {
11            max_dp[0][j] = max_dp[0][j-1] * grid[0][j];
12            min_dp[0][j] = min_dp[0][j-1] * grid[0][j];
13        }
14
15        for (int i = 1; i < m; i++) {
16            max_dp[i][0] = max_dp[i-1][0] * grid[i][0];
17            min_dp[i][0] = min_dp[i-1][0] * grid[i][0];
18        }
19
20        for (int i = 1; i < m; i++) {
21            for (int j = 1; j < n; j++) {
22                long curr = grid[i][j];
23
24                long max_top = max_dp[i-1][j], min_top = min_dp[i-1][j];
25                long max_left = max_dp[i][j-1], min_left = min_dp[i][j-1];
26
27                long[] candidates = {
28                    max_top * curr,
29                    min_top * curr,
30                    max_left * curr,
31                    min_left * curr
32                };
33
34                long max_val = candidates[0], min_val = candidates[0];
35
36                for (int k = 1; k < 4; k++) {
37                    max_val = Math.max(max_val, candidates[k]);
38                    min_val = Math.min(min_val, candidates[k]);
39                }
40
41                max_dp[i][j] = max_val;
42                min_dp[i][j] = min_val;
43            }
44        }
45
46        long result = max_dp[m-1][n-1];
47
48        if (result < 0) {
49            return -1;
50        }
51
52        return (int)(result % MOD);
53    }
54}