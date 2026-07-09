// Last updated: 7/9/2026, 5:05:21 PM
class Solution {
    public long minEnd(int n, int x) {
         long num = x ;
         for (int i = 1 ; i < n; i ++){
            num = (num+1)| x;
         }
         return num;
    }
}