// Last updated: 11/22/2026, 4:18:32 PM
1class Solution {
2    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
3        int len1 = nums1.length;
4        int len2 = nums2.length;
5
6        if (len1 > len2)
7            return findMedianSortedArrays(nums2, nums1);
8
9        int left = 0;
10        int right = len1;
11        while (left <= right) {
12            int part1 = (left + right) / 2;
13            int part2 = ((len1 + len2 + 1) / 2 - part1);
14
15            int l1 = (part1 == 0) ? Integer.MIN_VALUE : nums1[part1 - 1];
16            int r1 = (part1 == len1) ? Integer.MAX_VALUE : nums1[part1];
17            int l2 = (part2 == 0) ? Integer.MIN_VALUE : nums2[part2 - 1];
18            int r2 = (part2 == len2) ? Integer.MAX_VALUE : nums2[part2];
19
20            if ((l1 <= r2) && (l2 <= r1)) {
21                if ((len1 + len2) % 2 == 0) {
22                    return (Math.max(l1, l2) + Math.min(r1, r2)) / 2.0;
23                } else {
24                    return Math.max(l1, l2);
25                }
26            } else if (l1 > r2)
27                right = part1 - 1;
28            else
29                left = part1 + 1;
30        }
31        return 0.0;
32    }
33}