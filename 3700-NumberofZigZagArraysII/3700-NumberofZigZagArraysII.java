// Last updated: 6/24/2026, 12:09:26 PM
1class Solution {
2    static final long MOD = 1_000_000_007;
3
4    public int zigZagArrays(int n, int l, int r) {
5        int m = r - l + 1;
6
7        long[] up = new long[m];
8        for (int i = 0; i < m; i++) up[i] = i;
9
10        long[][] T = new long[m][m];
11        for (int i = 1; i < m; i++)
12            for (int k = m - i; k < m; k++)
13                T[i][k] = 1;
14
15        long[][] Tn = matpow(T, n - 2, m);
16
17        long ans = 0;
18        for (int i = 0; i < m; i++)
19            for (int j = 0; j < m; j++)
20                ans = (ans + Tn[i][j] * up[j]) % MOD;
21
22        return (int) (ans * 2 % MOD);
23    }
24
25    long[][] matmul(long[][] A, long[][] B, int sz) {
26        long[][] C = new long[sz][sz];
27        for (int i = 0; i < sz; i++)
28            for (int k = 0; k < sz; k++) {
29                if (A[i][k] == 0) continue;
30                for (int j = 0; j < sz; j++)
31                    C[i][j] = (C[i][j] + A[i][k] * B[k][j]) % MOD;
32            }
33        return C;
34    }
35
36    long[][] matpow(long[][] M, int p, int sz) {
37        long[][] res = new long[sz][sz];
38        for (int i = 0; i < sz; i++) res[i][i] = 1;
39        while (p > 0) {
40            if ((p & 1) == 1) res = matmul(res, M, sz);
41            M = matmul(M, M, sz);
42            p >>= 1;
43        }
44        return res;
45    }
46}