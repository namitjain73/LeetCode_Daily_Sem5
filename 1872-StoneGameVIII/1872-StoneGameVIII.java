// Last updated: 8/24/2026, 7:31:51 PM
1class Solution {
2    public int stoneGameVIII(int[] stones) {
3        int n = stones.length;
4
5        for (int i = 1; i < n; i++) {
6            stones[i] += stones[i - 1];
7        }
8
9        int best = stones[n - 1];
10
11        for (int i = n - 2; i >= 1; i--) {
12            best = Math.max(
13                best,
14                stones[i] - best
15            );
16        }
17
18        return best;
19    }
20}