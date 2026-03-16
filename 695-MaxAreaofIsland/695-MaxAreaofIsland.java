// Last updated: 3/16/2026, 10:56:45 AM
1class Solution {
2    public int maxAreaOfIsland(int[][] grid) {
3        int n = grid.length;
4        int m = grid[0].length;
5        boolean[][] visited = new boolean[n][m];
6        int ans = 0;
7        for (int i = 0; i < n; i++) {
8            for (int j = 0; j < m; j++) {
9                if (grid[i][j] == 1 && !visited[i][j]) {
10                    ans = Math.max(ans, dfs(grid, i, j, visited));
11                }
12            }
13        }
14        return ans;
15    }
16
17    public int dfs(int[][] grid, int i, int j, boolean[][] visited) {
18        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] != 1 || visited[i][j])
19            return 0;
20
21        int ans = 0;
22        visited[i][j] = true;
23        ans++;
24        int[] a = { 1, -1, 0, 0 };
25        int[] b = { 0, 0, 1, -1 };
26        for (int k = 0; k < 4; k++) {
27            int nx = i + a[k];
28            int ny = j + b[k];
29            ans += dfs(grid, nx, ny, visited);
30        }
31        return ans;
32    }
33}