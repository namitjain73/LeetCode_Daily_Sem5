// Last updated: 11/9/2025, 1:44:06 AM
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