// Last updated: 2/5/2026, 12:00:48 AM
1class Solution {
2    public int minCost(int n, int[][] edges) {
3        // Building augmented graph
4        ArrayList<int[]>[] adj = new ArrayList[n];
5        for (int i = 0; i < n; i++) 
6            adj[i] = new ArrayList<>();
7
8        for (int i = 0; i < edges.length; i++) {
9            int u = edges[i][0], v = edges[i][1], w = edges[i][2];
10            adj[u].add(new int[]{v, w});
11            adj[v].add(new int[]{u, 2 * w});
12        }
13
14        // Initialize distance array from 0 node
15        final int INF = 1000000000;
16        int[] dist = new int[n];
17        for (int i = 0; i < n; i++) 
18            dist[i] = INF;
19        dist[0] = 0;
20
21        // Dijkstra
22        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
23        pq.add(new int[]{0, 0});
24
25        while (!pq.isEmpty()) {
26            int[] cur = pq.poll();
27            int d = cur[0], u = cur[1];
28            if (u == n - 1)  // Early exit
29                return d;
30            if (d != dist[u])  // Stale edge
31                continue;
32
33            for (int i = 0; i < adj[u].size(); i++) {
34                int[] e = adj[u].get(i);
35                int v = e[0], w = e[1];
36                if (dist[u] + w < dist[v]) {  // Edge relaxation
37                    dist[v] = dist[u] + w;
38                    pq.add(new int[]{dist[v], v});
39                }
40            }
41        }
42
43        return -1;
44    }
45}