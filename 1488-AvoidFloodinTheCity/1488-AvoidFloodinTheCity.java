// Last updated: 1/10/2026, 11:22:58 PM
1class Solution {
2    public int longestArithSeqLength(int[] nums) {
3        int n = nums.length;
4        if (n <= 2)
5            return n;
6
7        int longest = 2;
8        Map<Integer, Integer>[] dp = new HashMap[n];
9
10        for (int i = 0; i < n; i++) {
11            dp[i] = new HashMap<>();
12            for (int j = 0; j < i; j++) {
13                int diff = nums[i] - nums[j];
14                dp[i].put(diff, dp[j].getOrDefault(diff, 1) + 1);
15                longest = Math.max(longest, dp[i].get(diff));
16            }
17        }
18
19        return longest;
20    }
21}