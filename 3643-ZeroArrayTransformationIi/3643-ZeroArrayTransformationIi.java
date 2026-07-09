// Last updated: 7/9/2026, 5:03:04 PM
class Solution {
    public int minZeroArray(int[] nums, int[][] queries) {
        // cnt stores the total decrement applied so far at the current index
        int cnt = 0; 
        // k represents how many queries have been used
        int k = 0; 
        int n = nums.length;
        // Difference array to efficiently apply range decrements
        int[] diff = new int[n];
        for (int i = 0; i < n; i++) {
            // If current decrements are not enough to reduce nums[i] to zero
            while ((diff[i] + cnt) < nums[i]) {
                // If no more queries are available, transformation is impossible
                if (k == queries.length) return -1;
                
                int l = queries[k][0];
                int r = queries[k][1];
                int v = queries[k][2];
                k++;

                // If this query does not affect current index, skip it
                if (r < i) continue;

                // Apply the decrement starting from max(l, i)
                // to avoid affecting already processed indices
                diff[Math.max(l, i)] += v;

                // Stop the decrement effect after index r
                if (r + 1 < n) diff[r + 1] -= v;
            }

            // Accumulate the decrement value for the next index
            cnt += diff[i];
        }

        return k;
    }
}
