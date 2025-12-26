// Last updated: 12/26/2025, 10:41:07 PM
1class Solution {
2    public long minEnd(int n, int x) {
3         long num = x ;
4         for (int i = 1 ; i < n; i ++){
5            num = (num+1)| x;
6         }
7         return num;
8    }
9}