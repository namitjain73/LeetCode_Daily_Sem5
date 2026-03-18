// Last updated: 3/19/2026, 12:43:46 AM
1class Solution {
2    public int countSubmatrices(int[][] grid, int k) {
3        int m = grid.length, n = grid[0].length;
4        int count = 0;
5        
6        for (int i = 0; i < m; i++) {
7            for (int j = 0; j < n; j++) {
8                if (i > 0) {
9                    grid[i][j] += grid[i-1][j];
10                }
11
12                if (j > 0) {
13                    grid[i][j] += grid[i][j-1];
14                }
15   
16                if (i > 0 && j > 0) {
17                    grid[i][j] -= grid[i-1][j-1];
18                }
19                
20                if (grid[i][j] <= k) {
21                    count++;
22                }
23            }
24        }
25        
26        return count;
27    }
28}