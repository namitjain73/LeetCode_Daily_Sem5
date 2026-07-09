// Last updated: 7/9/2026, 4:59:13 PM
class Solution {
    static Integer[][][] memo;

    public int maxPathScore(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        memo = new Integer[m][n][k + 1];
        
        int result = solve(grid, m - 1, n - 1, k);
        return result < 0 ? -1 : result;
    }

    private int solve(int[][] grid, int i, int j, int remK) {
        int currentCost = (grid[i][j] != 0 ? 1 : 0);
        if (remK < currentCost) {
            return -100000000; 
        }

        if (i == 0 && j == 0) {
            return grid[i][j];
        }

        if (memo[i][j][remK] != null) {
            return memo[i][j][remK];
        }

        int up = -100000000;
        int left = -100000000;

        if (i > 0) {
            up = solve(grid, i - 1, j, remK - currentCost);
        }
        
        if (j > 0) {
            left = solve(grid, i, j - 1, remK - currentCost);
        }
        int res = grid[i][j] + Math.max(up, left);
        
        return memo[i][j][remK] = res;
    }
}