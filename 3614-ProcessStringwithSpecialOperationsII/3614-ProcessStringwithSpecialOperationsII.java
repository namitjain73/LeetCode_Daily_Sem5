// Last updated: 6/17/2026, 9:25:33 PM
1class Solution {
2    public char processStr(String s, long k) {
3        long len = 0;
4        for (char c : s.toCharArray()) {
5            if (c == '*') len = Math.max(0, len - 1);
6            else if (c == '#') len *= 2;
7            else if (c != '%') len++;
8        }
9        if (k >= len) return '.';
10        for (int i = s.length() - 1; i >= 0; i--) {
11            char c = s.charAt(i);
12            if (c == '*') len++;
13            else if (c == '#') {
14                long half = len / 2;
15                if (k >= half) k -= half;
16                len = half;
17            }
18            else if (c == '%') {
19                k = len - 1 - k;
20            }
21            else {
22                if (k == len - 1) return c;
23                len--;
24            }
25        }
26        return '.';
27    }
28}