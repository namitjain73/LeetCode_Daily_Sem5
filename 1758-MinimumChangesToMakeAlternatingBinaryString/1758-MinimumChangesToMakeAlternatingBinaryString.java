// Last updated: 3/5/2026, 6:04:56 PM
1class Solution {
2    public int minOperations(String s) {
3        int n = s.length();
4        int chg0 = 0;
5        int chg1 = 0;
6
7        for(int i = 0; i < n; i++){
8            char e0 = (i % 2 == 0) ? '0' : '1';
9            char e1 = (i % 2 == 0) ? '1' : '0';
10
11            if(s.charAt(i) != e0) chg0++;
12            if(s.charAt(i) != e1) chg1++;
13        }
14
15        return Math.min(chg0, chg1);
16    }
17}