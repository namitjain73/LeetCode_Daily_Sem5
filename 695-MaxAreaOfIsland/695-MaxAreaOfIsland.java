// Last updated: 7/9/2026, 5:20:20 PM
class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] visited = new boolean[n][m];
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    ans = Math.max(ans, dfs(grid, i, j, visited));
                }
            }
        }
        return ans;
    }

    public int dfs(int[][] grid, int i, int j, boolean[][] visited) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] != 1 || visited[i][j])
            return 0;

        int ans = 0;
        visited[i][j] = true;
        ans++;
        int[] a = { 1, -1, 0, 0 };
        int[] b = { 0, 0, 1, -1 };
        for (int k = 0; k < 4; k++) {
            int nx = i + a[k];
            int ny = j + b[k];
            ans += dfs(grid, nx, ny, visited);
        }
        return ans;
    }
}