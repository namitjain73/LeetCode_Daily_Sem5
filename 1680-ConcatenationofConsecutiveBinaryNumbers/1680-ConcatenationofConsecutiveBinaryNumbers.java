// Last updated: 3/1/2026, 1:59:32 PM
1class Solution {
2    public int concatenatedBinary(int n) {
3        long mod = 1_000_000_007;
4        long ans = 0;
5        int bitLength = 0;
6
7        for (int i = 1; i <= n; i++) {
8            
9            // If i is power of 2, bit length increases
10            if ((i & (i - 1)) == 0) {
11                bitLength++;
12            }
13
14            ans = ((ans << bitLength) + i) % mod;
15        }
16
17        return (int) ans;
18    }
19}