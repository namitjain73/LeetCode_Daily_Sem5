// Last updated: 6/11/2026, 11:30:16 PM
1class Solution {
2    private static final int MOD = 1_000_000_007;
3
4    private int power(long a, long b) {
5        long ans = 1;
6        a %= MOD;
7
8        while (b > 0) {
9            if ((b & 1) == 1) {
10                ans = (ans * a) % MOD;
11            }
12
13            a = (a * a) % MOD;
14            b >>= 1;
15        }
16
17        return (int) ans;
18    }
19
20    private int dfs(int node, int parent, List<List<Integer>> adj) {
21        int ans = 0;
22
23        for (int child : adj.get(node)) {
24            if (child != parent) {
25                ans = Math.max(ans, 1 + dfs(child, node, adj));
26            }
27        }
28
29        return ans;
30    }
31
32    public int assignEdgeWeights(int[][] edges) {
33        int n = edges.length + 2;
34
35        List<List<Integer>> adj = new ArrayList<>();
36        for (int i = 0; i < n; i++) {
37            adj.add(new ArrayList<>());
38        }
39
40        for (int[] edge : edges) {
41            int u = edge[0];
42            int v = edge[1];
43
44            adj.get(u).add(v);
45            adj.get(v).add(u);
46        }
47
48        int depth = dfs(1, -1, adj);
49
50        return power(2, depth - 1);
51    }
52}