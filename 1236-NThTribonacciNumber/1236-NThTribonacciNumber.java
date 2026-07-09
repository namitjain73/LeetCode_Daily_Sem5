// Last updated: 7/9/2026, 5:17:43 PM
class Solution {
    public int tribonacci(int n) {
        int t0= 0;
        int t1 = 1;
        int t2 = 1;

        if(n == 0) return 0;
        if(n == 1 || n == 2) return 1;

        int ans= 0;
        n -= 2;
        while(n-- > 0){
            ans = t0+t1+t2;
            t0 = t1;
            t1 = t2;
            t2 = ans;
        }
        return ans;
    }
}