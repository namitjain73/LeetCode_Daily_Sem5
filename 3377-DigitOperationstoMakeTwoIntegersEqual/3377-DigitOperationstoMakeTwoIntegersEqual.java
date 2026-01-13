// Last updated: 1/13/2026, 11:34:28 PM
1import java.util.*;
2
3class Solution {
4    private void findPrime(boolean[] isPrime, int n) {
5        Arrays.fill(isPrime, true);
6        isPrime[0] = isPrime[1] = false;
7        
8        for (int i = 2; i * i < n; i++) {
9            if (isPrime[i]) {
10                for (int j = i * i; j < n; j += i) {
11                    isPrime[j] = false; 
12                }
13            }
14        }
15    }
16    private List<Integer> findNode(int n) {
17        List<Integer> neighbors = new ArrayList<>();
18        
19        for (int i = 1; i <= n; i *= 10) {
20            int d = (n / i) % 10;
21
22            if (d > 0) {
23                neighbors.add(n - i);
24            }
25
26            if (d < 9) {
27                neighbors.add(n + i);
28            }
29        }
30
31        return neighbors;
32    }
33
34    public int minOperations(int n, int m) {
35        final int MAX = 10000; 
36        final int INF = Integer.MAX_VALUE;
37        boolean[] isPrime = new boolean[MAX];
38        findPrime(isPrime, MAX);
39        
40        if (isPrime[n] || isPrime[m]) {
41            return -1;
42        }
43        int[] dist = new int[MAX];
44        Arrays.fill(dist, INF);
45        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
46
47        dist[n] = 0;
48        pq.add(new int[]{dist[n], n});
49
50        while (!pq.isEmpty()) {
51            int[] current = pq.poll();
52            int dis = current[0]; 
53            int num = current[1];
54            if (isPrime[num]) {
55                continue;
56            }
57            for (int neighbor : findNode(num)) {
58                if (isPrime[neighbor]) {
59                    continue;
60                }
61                if (dist[neighbor] > dis + num) {
62                    dist[neighbor] = dis + num;
63                    pq.add(new int[]{dist[neighbor], neighbor});
64                }
65            }
66        }
67        return dist[m] == INF ? -1 : m + dist[m];
68    }
69}