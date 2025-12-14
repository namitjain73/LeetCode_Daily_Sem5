// Last updated: 12/15/2025, 12:30:44 AM
1class Solution {
2    public int numberOfWays(String corridor) {
3        int MOD = (int) 1e9 + 7;
4        long ans = 1;
5        int cnt = 0, prev = -1;
6        
7        for (int i = 0; i < corridor.length(); i++) {
8            if (corridor.charAt(i) == 'S') {
9                cnt++;
10                if (cnt % 2 == 1 && cnt > 2) {
11                    ans = ans * (i - prev) % MOD;
12                }
13                if (cnt % 2 == 0) prev = i;
14            }
15        }
16        
17        return cnt % 2 == 0 && cnt > 0 ? (int)ans : 0;
18    }
19}