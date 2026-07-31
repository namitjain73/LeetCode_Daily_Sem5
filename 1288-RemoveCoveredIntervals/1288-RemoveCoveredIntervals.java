// Last updated: 7/31/2026, 10:37:40 PM
1class Solution {
2    public int removeCoveredIntervals(int[][] intervals) {
3
4        Arrays.sort(intervals, (a, b) -> {
5            if (a[0] != b[0])
6                return a[0] - b[0];
7            return b[1] - a[1];
8        });
9
10        int ans = intervals.length;
11
12        int low = intervals[0][0];
13        int high = intervals[0][1];
14
15        for (int i = 1; i < intervals.length; i++) {
16
17            if (intervals[i][0] == low || intervals[i][1] <= high) {
18                ans--;
19            } else {
20                low = intervals[i][0];
21                high = intervals[i][1];
22            }
23        }
24
25        return ans;
26    }
27}