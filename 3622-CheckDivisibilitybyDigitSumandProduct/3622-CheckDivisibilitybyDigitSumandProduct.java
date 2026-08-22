// Last updated: 8/22/2026, 10:41:04 PM
1class Solution {
2    public boolean checkDivisibility(int n) {
3        int sum = 0;
4        int pro = 1;
5        int  num = n;
6        while(n > 0){
7            int rem = n % 10;
8            sum += rem;
9            pro *= rem;
10            n  = n / 10;
11        }
12        return num % (sum+pro) == 0;
13    }
14}