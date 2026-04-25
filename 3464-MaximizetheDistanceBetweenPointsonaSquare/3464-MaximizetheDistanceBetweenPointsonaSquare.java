// Last updated: 4/26/2026, 1:19:14 AM
1import java.util.*;
2
3class Solution {
4    public int maxDistance(int side, int[][] points, int k) {
5        int n = points.length;
6        long[][] arr = new long[n][3];
7
8        for (int i = 0; i < n; i++) {
9            arr[i][0] = getPos(side, points[i][0], points[i][1]);
10            arr[i][1] = points[i][0];
11            arr[i][2] = points[i][1];
12        }
13
14        Arrays.sort(arr, Comparator.comparingLong(a -> a[0]));
15
16        int low = 0, high = 2 * side, ans = 0;
17
18        while (low <= high) {
19            int mid = low + (high - low) / 2;
20            if (can(arr, k, mid)) {
21                ans = mid;
22                low = mid + 1;
23            } else {
24                high = mid - 1;
25            }
26        }
27
28        return ans;
29    }
30
31    private boolean can(long[][] arr, int k, int dist) {
32        int n = arr.length;
33
34        for (int start = 0; start < n; start++) {
35            int cnt = 1;
36            int prev = start;
37
38            while (cnt < k) {
39                int next = nextIndex(arr, prev + 1, arr[prev], dist);
40                if (next == -1) break;
41                cnt++;
42                prev = next;
43            }
44
45            if (cnt == k && manhattan(arr[start], arr[prev]) >= dist) {
46                return true;
47            }
48        }
49        return false;
50    }
51
52    private int nextIndex(long[][] arr, int l, long[] prev, int dist) {
53        int r = arr.length - 1, ans = -1;
54
55        while (l <= r) {
56            int mid = l + (r - l) / 2;
57            if (manhattan(prev, arr[mid]) >= dist) {
58                ans = mid;
59                r = mid - 1;
60            } else {
61                l = mid + 1;
62            }
63        }
64
65        return ans;
66    }
67
68    private int manhattan(long[] a, long[] b) {
69        return (int)(Math.abs(a[1] - b[1]) + Math.abs(a[2] - b[2]));
70    }
71
72    private long getPos(int side, int x, int y) {
73        if (y == 0) return x;
74        if (x == side) return side + y;
75        if (y == side) return 3L * side - x;
76        return 4L * side - y;
77    }
78}