// Last updated: 1/29/2026, 10:15:28 PM
1import java.util.*;
2
3class Solution {
4    private void dijkstra(int src, List<int[]>[] adj, int[] dist) {
5        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
6        dist[src] = 0;
7        pq.offer(new int[]{0, src});
8
9        while (!pq.isEmpty()) {
10            int[] cur = pq.poll();
11            int d = cur[0], u = cur[1];
12
13            if (d > dist[u]) continue;
14
15            for (int[] edge : adj[u]) {
16                int v = edge[0], w = edge[1];
17                if (dist[v] > d + w) {
18                    dist[v] = d + w;
19                    pq.offer(new int[]{dist[v], v});
20                }
21            }
22        }
23    }
24
25    public long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {
26        if (source.length() != target.length()) return -1;
27
28        List<int[]>[] adj = new ArrayList[26];
29        for (int i = 0; i < 26; i++) adj[i] = new ArrayList<>();
30
31        for (int i = 0; i < original.length; i++) {
32            adj[original[i] - 'a'].add(new int[]{changed[i] - 'a', cost[i]});
33        }
34
35        int[][] dist = new int[26][26];
36        for (int i = 0; i < 26; i++) {
37            Arrays.fill(dist[i], Integer.MAX_VALUE);
38            dijkstra(i, adj, dist[i]);
39        }
40
41        long ans = 0;
42        for (int i = 0; i < source.length(); i++) {
43            int u = source.charAt(i) - 'a';
44            int v = target.charAt(i) - 'a';
45            if (u == v) continue;
46            if (dist[u][v] == Integer.MAX_VALUE) return -1;
47            ans += dist[u][v];
48        }
49
50        return ans;
51    }
52}