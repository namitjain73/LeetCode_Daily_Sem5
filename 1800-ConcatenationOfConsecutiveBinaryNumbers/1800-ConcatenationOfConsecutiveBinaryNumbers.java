// Last updated: 7/9/2026, 5:14:55 PM
class Solution {
    public int concatenatedBinary(int n) {
        long mod = 1_000_000_007;
        long ans = 0;
        int bitLength = 0;

        for (int i = 1; i <= n; i++) {
            
            // If i is power of 2, bit length increases
            if ((i & (i - 1)) == 0) {
                bitLength++;
            }

            ans = ((ans << bitLength) + i) % mod;
        }

        return (int) ans;
    }
}