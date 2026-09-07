// Last updated: 9/7/2026, 11:43:35 PM
1class Solution {
2    public int distinctSubseqII(String s) {
3        int MOD = 1_000_000_007;
4        long[] endsWith = new long[26];
5        long total = 0;
6        
7        for (int i = 0; i < s.length(); i++) {
8            int idx = s.charAt(i) - 'a';
9            
10            long newForCh = (total + 1) % MOD;
11            
12            total = (total - endsWith[idx] + newForCh) % MOD;
13            if (total < 0) {
14                total += MOD;
15            }
16            
17            endsWith[idx] = newForCh;
18        }
19        
20        return (int) total;
21    }
22}