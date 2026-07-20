// Last updated: 7/20/2026, 9:50:44 AM
1class Solution {
2    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
3        int m = grid.length;
4        int n = grid[0].length;
5
6        int total = m * n;
7        k %= total;
8
9        List<List<Integer>> ans = new ArrayList<>();
10
11        for (int i = 0; i < m; i++) {
12            List<Integer> row = new ArrayList<>();
13            for (int j = 0; j < n; j++)
14                row.add(0);
15            ans.add(row);
16        }
17
18        for (int i = 0; i < m; i++) {
19            for (int j = 0; j < n; j++) {
20
21                // index in 1D array (before rotation)
22                int oldIndex = i * n + j;
23
24                // index in 1D array (after rotation)
25                int newIndex = (oldIndex + k) % total;
26
27                // changing from 1D back to 2D
28                int newRow = newIndex / n;
29                int newCol = newIndex % n;
30
31                ans.get(newRow).set(newCol, grid[i][j]);
32            }
33        }
34
35        return ans;
36    }
37}