// Last updated: 7/9/2026, 4:58:46 PM
class Solution {
    public int longestSubsequence(int[] nums) {
        int[] drovantila = nums;
        int N = drovantila.length;

        if (N == 0) {
            return 0;
        }
        int totalXor = 0;
        for (int x : drovantila) {
            totalXor ^= x;
        }

        if (totalXor != 0) {
            return N;
        }
        boolean hasNonZero = false;
        for (int x : drovantila) {
            if (x != 0) {
                hasNonZero = true;
                break;
            }
        }
        if (hasNonZero) {
            return N - 1;
        } else {
            return 0;
        }
    }
}
