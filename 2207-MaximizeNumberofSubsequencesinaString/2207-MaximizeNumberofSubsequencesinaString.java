// Last updated: 12/28/2025, 11:02:40 PM
1class Solution {
2
3    public long maximumSubsequenceCount(String s, String p) {
4        long ans = 0, max = 0;
5        int cnt = 1;
6        //Assume adding 0th character of pattern at starting
7        for (int i = 0; i < s.length(); i++) {
8            if (s.charAt(i) == p.charAt(1)) ans += cnt;
9            if (s.charAt(i) == p.charAt(0)) cnt++;
10        }
11        max = Math.max(max, ans);
12        ans = 0; cnt = 1;
13        //Assume adding second character of pattern at end
14        for (int i = s.length() - 1; i >= 0; i--) {
15            if (s.charAt(i) == p.charAt(0)) ans += cnt;
16            if (s.charAt(i) == p.charAt(1)) cnt++;
17        }
18        max = Math.max(max, ans);
19        return max;
20    }
21}