// Last updated: 5/11/2026, 1:45:34 AM
1class Solution {
2    public int maximumJumps(int[] nums, int target) {
3
4        int[] dp = new int[nums.length];
5
6        // -1 means unreachable
7        Arrays.fill(dp, -1);
8
9        // starting index
10        dp[0] = 0;
11
12        for (int i = 0; i < nums.length; i++) {
13
14            // skip unreachable indices
15            if (i > 0 && dp[i] <= 0) {
16                continue;
17            }
18
19            for (int j = i + 1; j < nums.length; j++) {
20
21                // valid jump condition
22                if (Math.abs(nums[i] - nums[j]) <= Math.abs(target)) {
23
24                    // maximize number of jumps
25                    dp[j] = Math.max(dp[j], dp[i] + 1);
26                }
27            }
28        }
29
30        return dp[nums.length - 1];
31    }
32}