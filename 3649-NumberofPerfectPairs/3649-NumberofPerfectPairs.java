// Last updated: 1/14/2026, 11:11:50 PM
1import java.util.*;
2public class Solution {
3    public long perfectPairs(int[] nums) {
4        int n = nums.length;
5        long[] vals = new long[n];
6        for (int i = 0; i < n; i++) {
7            vals[i] = Math.abs((long) nums[i]);
8        }
9
10        Arrays.sort(vals);
11
12        long count = 0;
13        int right = 0;
14
15        for (int left = 0; left < n; left++) {
16            if (right <= left) right = left + 1;
17
18            while (right < n && vals[right] <= 2L * vals[left]) {
19                right++;
20            }
21            count += (right - left - 1);
22        }
23
24        return count;
25    }
26
27
28}