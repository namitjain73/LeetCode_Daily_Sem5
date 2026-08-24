// Last updated: 8/24/2026, 10:37:51 PM
1class Solution {
2
3    private int[][] memo;
4    private int[] suffix;
5    private int n;
6
7    public int stoneGameII(int[] piles) {
8
9        n = piles.length;
10
11        suffix = new int[n + 1];
12
13        for (int i = n - 1; i >= 0; i--) {
14            suffix[i] = suffix[i + 1] + piles[i];
15        }
16
17        memo = new int[n][n + 1];
18
19        return dfs(0, 1);
20    }
21
22    private int dfs(int i, int M) {
23
24        if (i >= n)
25            return 0;
26
27        if (2 * M >= n - i)
28            return suffix[i];
29
30        if (memo[i][M] != 0)
31            return memo[i][M];
32
33        int best = 0;
34
35        for (int X = 1; X <= 2 * M; X++) {
36
37            best = Math.max(
38                    best,
39                    suffix[i] - dfs(i + X, Math.max(M, X))
40            );
41        }
42
43        memo[i][M] = best;
44        return best;
45    }
46}