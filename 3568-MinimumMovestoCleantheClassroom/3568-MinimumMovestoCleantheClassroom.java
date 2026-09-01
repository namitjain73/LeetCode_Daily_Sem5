// Last updated: 9/2/2026, 12:13:35 AM
1class Solution {
2    public int minMoves(String[] classroom, int energy) {
3        int m = classroom.length;
4        int n = classroom[0].length();
5
6        int[][] id = new int[m][n];
7
8        for (int r = 0; r < m; r++) {
9            java.util.Arrays.fill(id[r], -1);
10        }
11
12        int k = 0;
13        int sr = 0, sc = 0;
14
15        for (int r = 0; r < m; r++) {
16            for (int c = 0; c < n; c++) {
17                if (classroom[r].charAt(c) == 'S') {
18                    sr = r;
19                    sc = c;
20                } else if (classroom[r].charAt(c) == 'L') {
21                    id[r][c] = k++;
22                }
23            }
24        }
25
26        if (k == 0) return 0;
27
28        int totalMask = (1 << k) - 1;
29
30        int[][][] best = new int[m][n][1 << k];
31
32        for (int r = 0; r < m; r++) {
33            for (int c = 0; c < n; c++) {
34                java.util.Arrays.fill(best[r][c], -1);
35            }
36        }
37
38        class State {
39            int r, c, mask, e, moves;
40
41            State(int r, int c, int mask, int e, int moves) {
42                this.r = r;
43                this.c = c;
44                this.mask = mask;
45                this.e = e;
46                this.moves = moves;
47            }
48        }
49
50        java.util.ArrayDeque<State> queue = new java.util.ArrayDeque<>();
51
52        best[sr][sc][0] = energy;
53        queue.offer(new State(sr, sc, 0, energy, 0));
54
55        int[] dr = {-1, 1, 0, 0};
56        int[] dc = {0, 0, -1, 1};
57
58        while (!queue.isEmpty()) {
59            State cur = queue.poll();
60
61            for (int d = 0; d < 4; d++) {
62                int nr = cur.r + dr[d];
63                int nc = cur.c + dc[d];
64
65                if (nr < 0 || nr >= m || nc < 0 || nc >= n)
66                    continue;
67
68                if (classroom[nr].charAt(nc) == 'X')
69                    continue;
70
71                int ne = cur.e - 1;
72
73                if (ne < 0)
74                    continue;
75
76                int nmask = cur.mask;
77
78                if (classroom[nr].charAt(nc) == 'R') {
79                    ne = energy;
80                }
81
82                if (classroom[nr].charAt(nc) == 'L') {
83                    nmask |= (1 << id[nr][nc]);
84                }
85
86                if (nmask == totalMask) {
87                    return cur.moves + 1;
88                }
89
90                if (ne <= best[nr][nc][nmask])
91                    continue;
92
93                best[nr][nc][nmask] = ne;
94
95                queue.offer(new State(nr, nc, nmask, ne, cur.moves + 1));
96            }
97        }
98
99        return -1;
100    }
101}