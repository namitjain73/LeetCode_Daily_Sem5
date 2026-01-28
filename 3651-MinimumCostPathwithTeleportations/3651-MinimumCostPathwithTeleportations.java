// Last updated: 1/29/2026, 1:24:24 AM
1class Solution {
2    static final int INF = 1000000000;
3    int rows = 0, cols = 0, maxval = 0;
4
5    void dp_iteration(int[][] dp, int[] best_teleport, int[][] grid) {
6        for (int r = rows - 1; r >= 0; --r) {
7            for (int c = cols - 1; c >= 0; --c) {
8                int walk = ((r != rows - 1) || (c != cols - 1)) ? INF : 0;
9                if (r + 1 < rows) walk = Math.min(walk, dp[r + 1][c] + grid[r + 1][c]);
10                if (c + 1 < cols) walk = Math.min(walk, dp[r][c + 1] + grid[r][c + 1]);
11                dp[r][c] = Math.min(walk, best_teleport[grid[r][c]]);
12            }
13        }
14    }
15
16    int[] build_teleport(int[][] dp, int[][] grid) {
17        int[] teleport = new int[maxval + 1];
18        for (int i = 0; i <= maxval; ++i) teleport[i] = INF;
19
20        // First build mincost for each v = value
21        for (int r = 0; r < rows; ++r)
22            for (int c = 0; c < cols; ++c)
23                teleport[grid[r][c]] = Math.min(teleport[grid[r][c]], dp[r][c]);
24
25        // Then build prefix mincost for v <= value
26        for (int v = 0; v <= maxval; ++v)
27            teleport[v] = Math.min(teleport[v], v > 0 ? teleport[v - 1] : INF);
28
29        return teleport;
30    }
31
32    public int minCost(int[][] grid, int k) {
33        rows = grid.length; cols = grid[0].length;
34        maxval = 0;
35        for (int r = 0; r < rows; ++r)
36            for (int c = 0; c < cols; ++c)
37                if (grid[r][c] > maxval) maxval = grid[r][c];
38
39        int[] best_teleport = new int[maxval + 1];
40        for (int i = 0; i <= maxval; ++i) best_teleport[i] = INF;
41
42        int[][] dp = new int[rows][cols];
43        for (int r = 0; r < rows; ++r)
44            for (int c = 0; c < cols; ++c)
45                dp[r][c] = INF;
46
47        dp[rows - 1][cols - 1] = 0; // zero cost to reach dest from dest
48
49        for (int t = 0; t <= k; ++t) { // t teleports allowed
50            dp_iteration(dp, best_teleport, grid);
51            best_teleport = build_teleport(dp, grid);
52        }
53
54        return dp[0][0];
55    }
56}