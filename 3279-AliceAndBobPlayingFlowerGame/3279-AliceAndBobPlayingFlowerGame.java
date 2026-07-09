// Last updated: 7/9/2026, 5:06:09 PM
class Solution {
    public long flowerGame(int n, int m) {
        return (((long)n + 1)/2 * ((long)m/2)) + (long)((long)(n)/2 * (((long)m+1)/2));
    }
}