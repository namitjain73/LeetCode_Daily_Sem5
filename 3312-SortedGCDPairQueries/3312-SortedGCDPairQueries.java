// Last updated: 7/18/2026, 12:10:24 AM
1class Solution {
2    public int[] gcdValues(int[] nums, long[] queries) {
3        int mx = Arrays.stream(nums).max().getAsInt();
4        int[] freq = new int[mx + 1];
5        for (int v : nums)
6            ++freq[v];
7
8        long[] g = new long[mx + 1];
9        for (int d = mx; d > 0; --d) {
10            long m = 0;
11            for (int k = d; k <= mx; k += d) {
12                m += freq[k];
13                g[d] -= g[k];           // remove gcd = 2d, 3d, ...  (g[d] is still 0 at k = d)
14            }
15            g[d] += m * (m - 1) / 2;    // pairs whose gcd is divisible by d
16        }
17
18        long[] s = g.clone();           // s[d] = pairs with gcd <= d
19        Arrays.parallelPrefix(s, Long::sum);
20
21        return Arrays.stream(queries).mapToInt(q -> upperBound(s, q)).toArray();
22    }
23
24    private int upperBound(long[] s, long q) {
25        int lo = 0, hi = s.length;
26        while (lo < hi) {
27            int mid = (lo + hi) >>> 1;
28            if (s[mid] > q) hi = mid;
29            else lo = mid + 1;
30        }
31        return lo;
32    }
33}