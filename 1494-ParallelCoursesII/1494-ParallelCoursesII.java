// Last updated: 1/17/2026, 11:29:21 PM
1class Solution {
2    public int minNumberOfSemesters(int n, int[][] relations, int k) {
3        int[] prereq = new int[n];
4        for (int[] req : relations) {
5            prereq[req[1] - 1] |= 1 << (req[0] - 1);
6        }
7        int[] dp = new int[(1 << n)];
8        Arrays.fill(dp, -1);
9        return solve(0, n, k, prereq, dp);
10    }
11    private int solve(int mask, int n, int k, int[] prereq, int[] dp) {
12        if (mask == (1 << n) - 1) {
13            return 0;
14        }
15        if (dp[mask] != -1) {
16            return dp[mask];
17        }
18        int availableCourses = 0;
19        for (int i = 0; i < n; i += 1) {
20            if ((mask & prereq[i]) == prereq[i]) {
21                if( (mask & (1<<i))>0 )
22                    continue;
23                availableCourses |= 1 << i;
24            }
25        }
26        int best = Integer.MAX_VALUE / 2;
27        for (int submask = availableCourses; submask > 0; submask = (submask - 1) & availableCourses) {
28            if (Integer.bitCount(submask) <= k) {
29                best = Math.min(best, 1 + solve(mask | submask, n, k, prereq, dp));
30            }
31        }
32        return dp[mask] = best;
33    }
34}