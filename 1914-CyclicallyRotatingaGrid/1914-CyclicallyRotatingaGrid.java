// Last updated: 5/9/2026, 8:30:59 PM
1class Solution {
2    public int[][] rotateGrid(int[][] grid, int k) {
3        int m = grid.length, n = grid[0].length;
4        int layers = Math.min(m, n) / 2;
5
6        for (int l = 0; l < layers; l++) {
7            List<Integer> vals = new ArrayList<>();
8            int top = l, left = l;
9            int bottom = m - l - 1, right = n - l - 1;
10
11            // top row
12            for (int j = left; j < right; j++)
13                vals.add(grid[top][j]);
14            // right col
15            for (int i = top; i < bottom; i++)
16                vals.add(grid[i][right]);
17            // bottom row
18            for (int j = right; j > left; j--)
19                vals.add(grid[bottom][j]);
20            // left col
21            for (int i = bottom; i > top; i--)
22                vals.add(grid[i][left]);
23
24            int len = vals.size();
25            int shift = k % len;
26            Collections.rotate(vals, -shift);
27
28            int idx = 0;
29            // put back
30            for (int j = left; j < right; j++)
31                grid[top][j] = vals.get(idx++);
32            for (int i = top; i < bottom; i++)
33                grid[i][right] = vals.get(idx++);
34            for (int j = right; j > left; j--)
35                grid[bottom][j] = vals.get(idx++);
36            for (int i = bottom; i > top; i--)
37                grid[i][left] = vals.get(idx++);
38        }
39        return grid;
40    }
41}