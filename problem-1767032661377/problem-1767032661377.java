// Last updated: 12/29/2025, 11:54:21 PM
1class Node {
2    int i;
3    ArrayList<Integer[]> nexts = new ArrayList<Integer[]>();
4    boolean active;
5    Node(int i, boolean active) {
6        this.i = i;
7        this.active = active;
8    }
9}
10
11
12class Solution {
13    int len;
14    int lenM;
15    Node[] nodes;
16    long k;
17    boolean can(int threshold) {
18        boolean[] visited = new boolean[len];
19        // idx, rmg
20        PriorityQueue<Long[]> heap = new PriorityQueue<Long[]>(
21            (A, B) -> {
22                long a = A[1], b = B[1];
23                if (b < a)  return -1;
24                if (b > a)  return 1;
25                return 0;
26            }
27        );
28        heap.offer(new Long[]{0L, k});
29
30        while (!heap.isEmpty()) {
31            Long[] top = heap.poll();
32            long _topIdx = top[0];
33            int topIdx = (int)_topIdx;
34            long topRmg = top[1];
35            if (topIdx == lenM)  return true;
36            if (visited[topIdx])    continue;
37
38            visited[topIdx] = true;
39            Node node = nodes[topIdx];
40            for (Integer[] next: node.nexts) {
41                int _nextIdx = next[0], nextCost = next[1];
42                Node nextNode = nodes[_nextIdx];
43                if (!nextNode.active)   continue;
44                long nextIdx = (long)_nextIdx;
45                if (visited[_nextIdx] || nextCost > topRmg || nextCost < threshold)
46                    continue;
47
48                Long[] addMe = new Long[]{nextIdx, topRmg - nextCost};
49                heap.offer(addMe);
50            }
51        }
52
53        return false;
54    }
55    public int findMaxPathScore(int[][] edges, boolean[] online, long k) {
56        len = online.length;
57        lenM = len - 1;
58        nodes = new Node[len];
59        this.k = k;
60        for (int i = 0; i < len; i++)
61            nodes[i] = new Node(i, online[i]);
62
63        int maxCost = Integer.MIN_VALUE;
64        for (int[] edge: edges) {
65            int f = edge[0], t = edge[1], cost = edge[2];
66            Node F = nodes[f];
67            F.nexts.add(new Integer[]{t, cost});
68            maxCost = Math.max(maxCost, cost);
69        }
70        int low = 0, high = maxCost;
71        if (!can(low)) return -1;
72        while (low < high) {
73            int mid = (1 + low + high) / 2;
74            if (can(mid))   low = mid;
75            else    high = mid - 1;
76        }
77        return low;
78    }
79}