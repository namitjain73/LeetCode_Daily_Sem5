// Last updated: 1/6/2026, 10:55:05 AM
1class Solution {
2    public int tribonacci(int n) {
3        int t0= 0;
4        int t1 = 1;
5        int t2 = 1;
6
7        if(n == 0) return 0;
8        if(n == 1 || n == 2) return 1;
9
10        int ans= 0;
11        n -= 2;
12        while(n-- > 0){
13            ans = t0+t1+t2;
14            t0 = t1;
15            t1 = t2;
16            t2 = ans;
17        }
18        return ans;
19    }
20}