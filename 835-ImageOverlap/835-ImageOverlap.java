// Last updated: 9/13/2026, 1:37:31 PM
1class Solution {
2    public int largestOverlap(int[][] img1, int[][] img2) {
3        int n = img1.length;
4        List<int[]> A = new ArrayList<>();
5        List<int[]> B = new ArrayList<>();
6        for (int i = 0; i < n; ++i) {
7            for (int j = 0; j < n; ++j) {
8                if (img1[i][j] == 1) A.add(new int[]{i, j});
9                if (img2[i][j] == 1) B.add(new int[]{i, j});
10            }
11        }
12        int[][] cnt = new int[2 * n][2 * n];
13        int best = 0;
14        for (int[] a : A) {
15            for (int[] b : B) {
16                int dx = b[0] - a[0] + n;
17                int dy = b[1] - a[1] + n;
18                best = Math.max(best, ++cnt[dx][dy]);
19            }
20        }
21        return best;
22    }
23}