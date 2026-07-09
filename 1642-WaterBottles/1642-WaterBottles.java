// Last updated: 7/9/2026, 5:15:49 PM
class Solution {
    public int numWaterBottles(int n, int r) {
        int ans = 0;
        int empty = 0;
        while(n > 0){
            ans += n;
            n += empty;
            empty = n%r;
            n = (n-empty)/r;

        }
        return ans;
    }
}