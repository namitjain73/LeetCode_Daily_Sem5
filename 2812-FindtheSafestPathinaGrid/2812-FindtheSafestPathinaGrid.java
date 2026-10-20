// Last updated: 10/20/2026, 11:45:31 PM
1class Solution {
2    private int[] roww = {0, 0, -1, 1};
3    private int[] coll = {-1, 1, 0, 0};
4    private void bfs(List<List<Integer>> grid, int[][] score, int n) {
5        Queue<int[]> q = new LinkedList<>();
6
7        for (int i = 0; i < n; i++) {
8            for (int j = 0; j < n; j++) {
9                if (grid.get(i).get(j) == 1) {
10                    score[i][j] = 0;
11                    q.offer(new int[]{i, j});
12                }
13            }
14        }
15
16        while (!q.isEmpty()) {
17            int[] t = q.poll();
18            int x = t[0], y = t[1];
19            int s = score[x][y];
20
21            for (int i = 0; i < 4; i++) {
22                int newX = x + roww[i];
23                int newY = y + coll[i];
24
25                if (newX >= 0 && newX < n && newY >= 0 && newY < n && score[newX][newY] > 1 + s) {
26                    score[newX][newY] = 1 + s;
27                    q.offer(new int[]{newX, newY});
28                }
29            }
30        }
31    }
32
33    public int maximumSafenessFactor(List<List<Integer>> grid) {
34        int n = grid.size();
35        if (grid.get(0).get(0) == 1 || grid.get(n - 1).get(n - 1) == 1) {
36            return 0;
37        }
38
39        int[][] score = new int[n][n];
40        for (int[] row : score) Arrays.fill(row, Integer.MAX_VALUE);
41        bfs(grid, score, n);
42
43        boolean[][] vis = new boolean[n][n];
44        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[0] - a[0]);
45        pq.offer(new int[]{score[0][0], 0, 0});
46
47        while (!pq.isEmpty()) {
48            int[] temp = pq.poll();
49            int safe = temp[0];
50            int i = temp[1], j = temp[2];
51
52            if (i == n - 1 && j == n - 1) return safe;
53            vis[i][j] = true;
54
55            for (int k = 0; k < 4; k++) {
56                int newX = i + roww[k];
57                int newY = j + coll[k];
58
59                if (newX >= 0 && newX < n && newY >= 0 && newY < n && !vis[newX][newY]) {
60                    int s = Math.min(safe, score[newX][newY]);
61                    pq.offer(new int[]{s, newX, newY});
62                    vis[newX][newY] = true;
63                }
64            }
65        }
66
67        return -1;
68    }
69}