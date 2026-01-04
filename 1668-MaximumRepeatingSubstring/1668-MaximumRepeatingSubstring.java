// Last updated: 1/4/2026, 3:23:57 PM
1class Solution {
2    public int maxRepeating(String s, String w) {
3
4        int ans = 0;
5        StringBuilder sb = new StringBuilder(w);
6        while(s.contains(sb.toString())) {
7            ans++;
8            sb.append(w);
9        }
10        return ans;
11    }
12}