// Last updated: 7/9/2026, 5:02:46 PM
import java.util.*;

class Solution {
    private void findPrime(boolean[] isPrime, int n) {
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;
        
        for (int i = 2; i * i < n; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j < n; j += i) {
                    isPrime[j] = false; 
                }
            }
        }
    }
    private List<Integer> findNode(int n) {
        List<Integer> neighbors = new ArrayList<>();
        
        for (int i = 1; i <= n; i *= 10) {
            int d = (n / i) % 10;

            if (d > 0) {
                neighbors.add(n - i);
            }

            if (d < 9) {
                neighbors.add(n + i);
            }
        }

        return neighbors;
    }

    public int minOperations(int n, int m) {
        final int MAX = 10000; 
        final int INF = Integer.MAX_VALUE;
        boolean[] isPrime = new boolean[MAX];
        findPrime(isPrime, MAX);
        
        if (isPrime[n] || isPrime[m]) {
            return -1;
        }
        int[] dist = new int[MAX];
        Arrays.fill(dist, INF);
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);

        dist[n] = 0;
        pq.add(new int[]{dist[n], n});

        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int dis = current[0]; 
            int num = current[1];
            if (isPrime[num]) {
                continue;
            }
            for (int neighbor : findNode(num)) {
                if (isPrime[neighbor]) {
                    continue;
                }
                if (dist[neighbor] > dis + num) {
                    dist[neighbor] = dis + num;
                    pq.add(new int[]{dist[neighbor], neighbor});
                }
            }
        }
        return dist[m] == INF ? -1 : m + dist[m];
    }
}