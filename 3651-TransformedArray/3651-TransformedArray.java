// Last updated: 7/9/2026, 5:02:49 PM
class Solution {
    public int[] constructTransformedArray(int[] A) {
        int n = A.length;
        int[] res = new int[n];

        for (int i = 0; i < n; i++)
            res[i] = A[(((i + A[i]) % n) + n) % n];

        return res;
    }
}
