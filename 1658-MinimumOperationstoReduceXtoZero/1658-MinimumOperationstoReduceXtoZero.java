// Last updated: 9/23/2026, 8:32:44 PM
1class Solution {
2    public int minOperations(int[] nums, int x) {
3        int minOperation = Integer.MAX_VALUE;
4        int size = nums.length;
5        int curSum = 0;
6        int left = -1;
7        int right = size;
8        while (left < size - 1 && curSum < x) {
9            curSum += nums[++left];
10        }
11        if (curSum == x) {
12            minOperation = Math.min(minOperation, left + 1);
13        }
14        while (left >= 0) {
15            curSum -= nums[left--];
16            while (right > left + 1 && curSum < x) {
17                curSum += nums[--right];
18            }
19            if (curSum == x) {
20                minOperation = Math.min(
21                    minOperation,
22                    (left + 1) + (size - right)
23                );
24            }
25        }
26        return minOperation == Integer.MAX_VALUE ? -1 : minOperation;
27    }
28}