// Last updated: 8/16/2026, 11:23:13 PM
1class Solution {
2    public boolean stoneGameIX(int[] stones) {
3        int c0 = 0;
4        int c1 = 0;
5        int c2 = 0;
6        for (int stone : stones) {
7            if (stone % 3 == 0) {
8                c0++;
9            } 
10            else if (stone % 3 == 1) {
11                c1++;
12            } 
13            else {
14                c2++;
15            }
16        }
17        if (c0 % 2 == 0) {
18            return c1 > 0 && c2 > 0;
19        }
20        return Math.abs(c1 - c2) > 2;
21    }
22}