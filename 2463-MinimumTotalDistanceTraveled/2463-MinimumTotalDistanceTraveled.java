// Last updated: 4/15/2026, 2:23:17 AM
1class Solution {
2    public long minimumTotalDistance(List<Integer> robot, int[][] factory) {
3        Collections.sort(robot);
4        Arrays.sort(factory, (a, b) -> a[0] - b[0]);
5
6        int r = robot.size();
7        int f = factory.length;
8        long[][] dp = new long[r + 1][f + 1];
9
10        for (int i = 0; i <= r; i++) {
11            Arrays.fill(dp[i], Long.MAX_VALUE / 2);
12        }
13
14        for (int j = 0; j <= f; j++) {
15            dp[0][j] = 0;
16        }
17
18        for (int j = 1; j <= f; j++) {
19            int pos = factory[j-1][0], limit = factory[j-1][1];
20
21            for (int i = 0; i <= r; i++) {
22                dp[i][j] = dp[i][j-1];
23
24                long dist = 0;
25                for (int k = 1; k <= limit && i - k >= 0; k++) {
26                    dist += Math.abs(robot.get(i - k) - pos);
27                    dp[i][j] = Math.min(dp[i][j], dp[i - k][j - 1] + dist);
28                }
29            }
30        }
31
32        return dp[r][f];
33    }
34}