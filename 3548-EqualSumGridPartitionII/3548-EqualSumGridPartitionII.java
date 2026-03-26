// Last updated: 3/27/2026, 1:29:09 AM
1class Solution {
2    public boolean canPartitionGrid(int[][] grid) {
3        int m = grid.length, n = grid[0].length;
4
5        long total = 0;
6
7        HashMap<Long, Integer> bottom = new HashMap<>();
8        HashMap<Long, Integer> top = new HashMap<>();
9        HashMap<Long, Integer> left = new HashMap<>();
10        HashMap<Long, Integer> right = new HashMap<>();
11
12        // Initialize bottom and right maps
13        for (int[] row : grid) {
14            for (int x : row) {
15                total += x;
16                bottom.put((long)x, bottom.getOrDefault((long)x, 0) + 1);
17                right.put((long)x, right.getOrDefault((long)x, 0) + 1);
18            }
19        }
20
21        long sumTop = 0;
22
23        // Horizontal cuts
24        for (int i = 0; i < m - 1; i++) {
25            for (int j = 0; j < n; j++) {
26                int val = grid[i][j];
27                sumTop += val;
28
29                top.put((long)val, top.getOrDefault((long)val, 0) + 1);
30                bottom.put((long)val, bottom.get((long)val) - 1);
31            }
32
33            long sumBottom = total - sumTop;
34
35            if (sumTop == sumBottom) return true;
36
37            long diff = Math.abs(sumTop - sumBottom);
38
39            if (sumTop > sumBottom) {
40                if (check(top, grid, 0, i, 0, n - 1, diff)) return true;
41            } else {
42                if (check(bottom, grid, i + 1, m - 1, 0, n - 1, diff)) return true;
43            }
44        }
45
46        long sumLeft = 0;
47
48        // Vertical cuts
49        for (int j = 0; j < n - 1; j++) {
50            for (int i = 0; i < m; i++) {
51                int val = grid[i][j];
52                sumLeft += val;
53
54                left.put((long)val, left.getOrDefault((long)val, 0) + 1);
55                right.put((long)val, right.get((long)val) - 1);
56            }
57
58            long sumRight = total - sumLeft;
59
60            if (sumLeft == sumRight) return true;
61
62            long diff = Math.abs(sumLeft - sumRight);
63
64            if (sumLeft > sumRight) {
65                if (check(left, grid, 0, m - 1, 0, j, diff)) return true;
66            } else {
67                if (check(right, grid, 0, m - 1, j + 1, n - 1, diff)) return true;
68            }
69        }
70
71        return false;
72    }
73
74    private boolean check(HashMap<Long, Integer> mp, int[][] grid,
75                          int r1, int r2, int c1, int c2, long diff) {
76
77        int rows = r2 - r1 + 1;
78        int cols = c2 - c1 + 1;
79
80        // single cell
81        if (rows * cols == 1) return false;
82
83        // 1D row
84        if (rows == 1) {
85            return grid[r1][c1] == diff || grid[r1][c2] == diff;
86        }
87
88        // 1D column
89        if (cols == 1) {
90            return grid[r1][c1] == diff || grid[r2][c1] == diff;
91        }
92
93        return mp.getOrDefault(diff, 0) > 0;
94    }
95}