// Last updated: 7/9/2026, 5:13:46 PM
class Solution {
    public int countTriples(int n) {
        int cnt = 0;
        for (int a = 1; a < n; a++) {
            for (int b = a + 1; b < n; b++) {
                int sumSquares = a * a + b * b;
                int c = (int) Math.sqrt(sumSquares);
                if (c * c == sumSquares && c <= n) {
                    cnt += 2;
                }
            }
        }
        return cnt;
    }
}
