// Last updated: 1/27/2026, 11:29:41 PM
1class Solution {
2    public int minZeroArray(int[] nums, int[][] queries) {
3        // cnt stores the total decrement applied so far at the current index
4        int cnt = 0; 
5        // k represents how many queries have been used
6        int k = 0; 
7        int n = nums.length;
8        // Difference array to efficiently apply range decrements
9        int[] diff = new int[n];
10        for (int i = 0; i < n; i++) {
11            // If current decrements are not enough to reduce nums[i] to zero
12            while ((diff[i] + cnt) < nums[i]) {
13                // If no more queries are available, transformation is impossible
14                if (k == queries.length) return -1;
15                
16                int l = queries[k][0];
17                int r = queries[k][1];
18                int v = queries[k][2];
19                k++;
20
21                // If this query does not affect current index, skip it
22                if (r < i) continue;
23
24                // Apply the decrement starting from max(l, i)
25                // to avoid affecting already processed indices
26                diff[Math.max(l, i)] += v;
27
28                // Stop the decrement effect after index r
29                if (r + 1 < n) diff[r + 1] -= v;
30            }
31
32            // Accumulate the decrement value for the next index
33            cnt += diff[i];
34        }
35
36        return k;
37    }
38}
39