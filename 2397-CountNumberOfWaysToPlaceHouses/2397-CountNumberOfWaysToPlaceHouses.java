// Last updated: 7/9/2026, 5:10:35 PM
class Solution {
    public int countHousePlacements(int n) {
        int a = 1;
        int b= 1;
        int c = 2;
        int mod = (int)1e9 + 7;
        for(int i  = 0 ;i < n ; i++){
            c = (a+b)% mod;
            a = b % mod;
            b = c % mod;
        }
        return (int)(1L * b * b % mod);
    }
}