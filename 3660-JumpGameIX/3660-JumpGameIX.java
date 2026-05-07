// Last updated: 5/8/2026, 1:46:39 AM
1class Solution {
2    public int[] maxValue(int[] nums) {
3        int n = nums.length;
4
5        int[] ans = new int[n];
6        int[] preMax = new int[n];
7
8        // Prefix maximum
9        preMax[0] = nums[0];
10
11        for (int i = 1; i < n; i++) {
12            preMax[i] = Math.max(preMax[i - 1], nums[i]);
13        }
14
15        int sufMin = Integer.MAX_VALUE;
16
17        // Traverse from right to left
18        for (int i = n - 1; i >= 0; i--) {
19
20            if (preMax[i] > sufMin)
21                ans[i] = ans[i + 1];
22            else
23                ans[i] = preMax[i];
24
25            sufMin = Math.min(sufMin, nums[i]);
26        }
27
28        return ans;
29    }
30}