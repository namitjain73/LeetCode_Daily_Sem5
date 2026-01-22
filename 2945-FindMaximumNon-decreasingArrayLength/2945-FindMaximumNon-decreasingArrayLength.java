// Last updated: 1/22/2026, 11:45:31 PM
1class Solution {
2        public int findMaximumLength(int[] A) {
3        int n = A.length;
4        int[] pre = new int[n + 2], dp = new int[n + 1];
5        long[] acc = new long[n + 1];
6        for (int i = 1; i <= n; i ++) {
7            acc[i] = acc[i - 1] + A[i - 1];
8        }
9        for (int i = 0, j = 1; j <= n; j++) {
10            i = Math.max(i, pre[j]); 
11            dp[j] = dp[i] + 1;
12            int k = Arrays.binarySearch(acc, 2 * acc[j] - acc[i]);
13            if (k < 0) {
14                k = -k - 1;
15            }
16            pre[k] = j;
17        }
18        return dp[n];
19    }
20}