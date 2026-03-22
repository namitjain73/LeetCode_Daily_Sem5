// Last updated: 3/23/2026, 2:19:55 AM
1class Solution {
2    public boolean findRotation(int[][] mat, int[][] target) {
3        int n = mat.length;
4
5        for (int rot = 0; rot < 4; rot++) {
6            if (is_same(mat, target)) {
7                return true;
8            }
9            mat = rotate90(mat);
10        }
11
12        return false;
13    }
14
15    private boolean is_same(int[][] a, int[][] b) {
16        int n = a.length;
17        for (int i = 0; i < n; i++) {
18            for (int j = 0; j < n; j++) {
19                if (a[i][j] != b[i][j]) {
20                    return false;
21                }
22            }
23        }
24
25        return true;
26    }
27
28    private int[][] rotate90(int[][] mat) {
29        int n = mat.length;
30        int[][] rotated = new int[n][n];
31
32        for (int i = 0; i < n; i++) {
33            for (int j = 0; j < n; j++) {
34                rotated[j][n - 1 - i] = mat[i][j];
35            }
36        }
37
38        return rotated;
39    }
40}