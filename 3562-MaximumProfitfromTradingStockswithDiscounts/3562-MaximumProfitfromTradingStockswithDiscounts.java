// Last updated: 12/16/2025, 3:40:47 PM
1import java.util.*;
2
3class Solution {
4
5    int B;
6    List<Integer>[] tree;
7    int[] present, future;
8    int[][][] dp; // dp[node][parentBought][budget]
9
10    public int maxProfit(int n, int[] present, int[] future,
11            int[][] hierarchy, int budget) {
12
13        this.B = budget;
14        this.present = present;
15        this.future = future;
16
17        tree = new ArrayList[n];
18        for (int i = 0; i < n; i++)
19            tree[i] = new ArrayList<>();
20
21        for (int[] e : hierarchy) {
22            tree[e[0] - 1].add(e[1] - 1);
23        }
24
25        dp = new int[n][2][B + 1];
26
27        dfs(0);
28
29        int ans = 0;
30        for (int b = 0; b <= B; b++) {
31            ans = Math.max(ans, dp[0][0][b]);
32        }
33        return ans;
34    }
35
36    // Merge two knapsack arrays
37    private int[] merge(int[] A, int[] B2) {
38        int[] C = new int[B + 1];
39        Arrays.fill(C, Integer.MIN_VALUE / 2);
40
41        for (int i = 0; i <= B; i++) {
42            if (A[i] < 0)
43                continue;
44            for (int j = 0; i + j <= B; j++) {
45                C[i + j] = Math.max(C[i + j], A[i] + B2[j]);
46            }
47        }
48        return C;
49    }
50
51    private void dfs(int u) {
52        for (int v : tree[u]) {
53            dfs(v);
54        }
55
56        for (int parentBought = 0; parentBought <= 1; parentBought++) {
57
58            int price = parentBought == 1 ? present[u] / 2 : present[u];
59            int profit = future[u] - price;
60
61            // Option 1: skip buying u
62            int[] skip = new int[B + 1];
63            for (int v : tree[u]) {
64                skip = merge(skip, dp[v][0]);
65            }
66
67            // Option 2: buy u
68            int[] take = new int[B + 1];
69            Arrays.fill(take, Integer.MIN_VALUE / 2);
70
71            if (price <= B) {
72                int[] base = new int[B + 1];
73                for (int v : tree[u]) {
74                    base = merge(base, dp[v][1]);
75                }
76                for (int b = price; b <= B; b++) {
77                    take[b] = base[b - price] + profit;
78                }
79            }
80
81            // Best of take / skip
82            for (int b = 0; b <= B; b++) {
83                dp[u][parentBought][b] = Math.max(skip[b], take[b]);
84            }
85        }
86    }
87}