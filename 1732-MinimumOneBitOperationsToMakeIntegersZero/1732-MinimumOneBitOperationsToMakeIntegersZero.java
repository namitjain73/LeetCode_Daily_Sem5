// Last updated: 7/9/2026, 5:15:18 PM
class Solution {
    public int minimumOneBitOperations(int n) {
        int result = 0;
        while (n > 0) {
            result ^= n;
            n = n >> 1;
        }
        
        return result;
    }
}