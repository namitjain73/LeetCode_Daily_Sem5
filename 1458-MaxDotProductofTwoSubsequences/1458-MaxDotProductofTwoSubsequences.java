// Last updated: 1/9/2026, 1:23:07 AM
1import java.util.*;
2class Solution {
3    int[] nums1, nums2;
4    int[][] memo;
5    int n, m;
6    final int NEG_INF = (int) -1e9;
7
8    int dp(int i, int j) {
9        if (i == n || j == m)
10            return NEG_INF;
11
12        if (memo[i][j] != Integer.MIN_VALUE)
13            return memo[i][j];
14
15        int take = nums1[i] * nums2[j];
16
17        int res = Math.max(
18            Math.max(
19                take + dp(i + 1, j + 1), // take both and continue
20                take                    // take and end here
21            ),
22            Math.max(
23                dp(i + 1, j),           // skip nums1[i]
24                dp(i, j + 1)            // skip nums2[j]
25            )
26        );
27
28        return memo[i][j] = res;
29    }
30
31    public int maxDotProduct(int[] a, int[] b) {
32        nums1 = a;
33        nums2 = b;
34        n = nums1.length;
35        m = nums2.length;
36
37        memo = new int[n][m];
38        for (int i = 0; i < n; i++)
39            Arrays.fill(memo[i], Integer.MIN_VALUE);
40
41        return dp(0, 0);
42    }
43}