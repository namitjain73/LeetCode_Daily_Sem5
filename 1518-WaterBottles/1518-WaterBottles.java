// Last updated: 10/1/2025, 11:40:19 AM
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