// Last updated: 7/9/2026, 5:01:06 PM
import java.util.*;

class Solution {
    static int LOG = 17;
    static int[][] up;
    static int[] depth;
    static List<Integer>[] adj;
    static long[] pow;
    static final int MOD = 1_000_000_007;

    public int[] assignEdgeWeights(int[][] edges, int[][] queries) {

        int n = edges.length + 1;

        adj = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) adj[i] = new ArrayList<>();

        for (int[] e : edges) {
            adj[e[0]].add(e[1]);
            adj[e[1]].add(e[0]);
        }

        depth = new int[n + 1];
        up = new int[n + 1][LOG];

        dfs(1, 1);

        for (int j = 1; j < LOG; j++) {
            for (int i = 1; i <= n; i++) {
                up[i][j] = up[up[i][j - 1]][j - 1];
            }
        }

        pow = new long[n + 1];
        pow[0] = 1;
        for (int i = 1; i <= n; i++) {
            pow[i] = (pow[i - 1] * 2) % MOD;
        }

        int[] ans = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            int u = queries[i][0];
            int v = queries[i][1];

            int lcaNode = lca(u, v);
            int dist = depth[u] + depth[v] - 2 * depth[lcaNode];

            if (dist == 0) ans[i] = 0;
            else ans[i] = (int) pow[dist - 1];
        }

        return ans;
    }

    void dfs(int node, int parent) {
        up[node][0] = parent;

        for (int nei : adj[node]) {
            if (nei == parent) continue;
            depth[nei] = depth[node] + 1;
            dfs(nei, node);
        }
    }

    int lca(int a, int b) {
        if (depth[a] < depth[b]) {
            int temp = a;
            a = b;
            b = temp;
        }

        for (int i = LOG - 1; i >= 0; i--) {
            if (depth[a] - (1 << i) >= depth[b]) {
                a = up[a][i];
            }
        }

        if (a == b) return a;

        for (int i = LOG - 1; i >= 0; i--) {
            if (up[a][i] != up[b][i]) {
                a = up[a][i];
                b = up[b][i];
            }
        }

        return up[a][0];
    }
}