// Last updated: 7/9/2026, 5:07:47 PM
class Solution {
    public int makeTheIntegerZero(int num1, int num2) {
        for (int k = 1; k <= 60; k++) {
            long x = 1L * num1 - 1L * num2 * k;
            if (x < k) {
                return -1;
            }
            if (k >= Long.bitCount(x)) {
                return k;
            }
        }
        return -1;
    }
}