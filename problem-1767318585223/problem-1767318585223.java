// Last updated: 1/2/2026, 7:19:45 AM
1class Solution {
2    public int edgeScore(int[] edges) {
3        int n = edges.length;
4        long[] ans = new long[n];
5        long max = -1;
6        for(int i =  0 ; i < n ; i++){
7            ans[edges[i]] += i;
8            max = Math.max(max,ans[edges[i]]);
9        }
10        int a = -1;
11        for(int i = 0 ; i < n ; i++){
12            if(ans[i]== max) return i;
13        }
14        return -1;
15    }
16}