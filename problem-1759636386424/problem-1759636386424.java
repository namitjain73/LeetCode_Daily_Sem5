// Last updated: 10/5/2025, 9:23:06 AM
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
