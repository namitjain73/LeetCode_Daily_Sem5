// Last updated: 3/21/2026, 1:59:48 AM
1// Added using AI
2class Solution {
3    public int[][] minAbsDiff(int[][] grid, int k) {
4        int m = grid.length, n = grid[0].length;
5        int[][] ans = new int[m - k + 1][n - k + 1];
6
7        for (int i = 0; i <= m - k; i++) {
8            for (int j = 0; j <= n - k; j++) {
9                List<Integer> v = new ArrayList<>();
10                for (int x = i; x < i + k; x++)
11                    for (int y = j; y < j + k; y++)
12                        v.add(grid[x][y]);
13
14                Collections.sort(v);
15                int mn = Integer.MAX_VALUE;
16                int prev = v.get(0);
17                for (int p = 1; p < v.size(); p++) {
18                    if (v.get(p) != prev)
19                        mn = Math.min(mn, v.get(p) - prev);
20                    prev = v.get(p);
21                }
22                ans[i][j] = (mn == Integer.MAX_VALUE) ? 0 : mn;
23            }
24        }
25        return ans;
26    }
27}