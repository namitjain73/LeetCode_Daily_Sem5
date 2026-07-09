// Last updated: 7/9/2026, 5:14:32 PM
class Pair {
    int node, weight;
    
    Pair(int node, int weight) {
        this.node = node;
        this.weight = weight;
    }
}

class Solution {
    public int countRestrictedPaths(int n, int[][] edges) {
        List<List<Pair>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            int u = edge[0], v = edge[1], w = edge[2];
            adj.get(u).add(new Pair(v, w));
            adj.get(v).add(new Pair(u, w));
        }

        int[] dist = new int[n + 1];
        int[] ans = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[n] = 0;
        ans[n] = 1;
        PriorityQueue<Pair> heap = new PriorityQueue<>((a, b) -> a.weight - b.weight);
        heap.offer(new Pair(n, 0));
        int mod = (int) 1e9 + 7;

        while (!heap.isEmpty()) {
            Pair top = heap.poll();
            int d = top.weight, x = top.node;
            if (d > dist[x]) continue;
            if (x == 1) break;
            for (Pair neighbor : adj.get(x)) {
                int y = neighbor.node, w = neighbor.weight;
                if (dist[y] > dist[x] + w) {
                    dist[y] = dist[x] + w;
                    heap.offer(new Pair(y, dist[y]));
                }
                if (dist[y] > dist[x]) {
                    ans[y] = (ans[y] + ans[x]) % mod;
                }
            }
        }
        return ans[1];
    }
}