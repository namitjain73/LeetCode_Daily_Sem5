// Last updated: 2/6/2026, 2:04:50 AM
1class Solution {
2    public int[] constructTransformedArray(int[] A) {
3        int n = A.length;
4        int[] res = new int[n];
5
6        for (int i = 0; i < n; i++)
7            res[i] = A[(((i + A[i]) % n) + n) % n];
8
9        return res;
10    }
11}
12