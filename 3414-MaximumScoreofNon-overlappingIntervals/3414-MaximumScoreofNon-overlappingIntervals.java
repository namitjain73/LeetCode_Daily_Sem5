// Last updated: 9/12/2026, 5:12:00 PM
1import java.util.*;
2
3class Solution {
4
5    static class Node {
6        long score;
7        int[] ids;
8
9        Node(long score, int[] ids) {
10            this.score = score;
11            this.ids = ids;
12        }
13    }
14
15    private boolean better(Node a, Node b) {
16        if (a == null) {
17            return false;
18        }
19
20        if (b == null) {
21            return true;
22        }
23
24        if (a.score != b.score) {
25            return a.score > b.score;
26        }
27
28        int len = Math.min(a.ids.length, b.ids.length);
29
30        for (int i = 0; i < len; i++) {
31            if (a.ids[i] != b.ids[i]) {
32                return a.ids[i] < b.ids[i];
33            }
34        }
35
36        return a.ids.length < b.ids.length;
37    }
38
39    private int[] addSorted(int[] ids, int value) {
40        int[] result = Arrays.copyOf(ids, ids.length + 1);
41
42        result[ids.length] = value;
43
44        Arrays.sort(result);
45
46        return result;
47    }
48
49    private int lowerBound(long[] ends, int length, long target) {
50        int left = 0;
51        int right = length;
52
53        while (left < right) {
54            int mid = left + (right - left) / 2;
55
56            if (ends[mid] >= target) {
57                right = mid;
58            } else {
59                left = mid + 1;
60            }
61        }
62
63        return left;
64    }
65
66    public int[] maximumWeight(List<List<Integer>> intervals) {
67        int n = intervals.size();
68
69        final int K = 4;
70
71        long[][] arr = new long[n][4];
72
73        for (int i = 0; i < n; i++) {
74            arr[i][0] = intervals.get(i).get(0);
75            arr[i][1] = intervals.get(i).get(1);
76            arr[i][2] = intervals.get(i).get(2);
77            arr[i][3] = i;
78        }
79
80        Arrays.sort(arr, (a, b) -> Long.compare(a[1], b[1]));
81
82        long[] ends = new long[n];
83
84        for (int i = 0; i < n; i++) {
85            ends[i] = arr[i][1];
86        }
87
88        Node[][] dp = new Node[K + 1][n + 1];
89
90        for (int i = 0; i <= n; i++) {
91            dp[0][i] = new Node(0, new int[0]);
92        }
93
94        for (int i = 1; i <= n; i++) {
95            long left = arr[i - 1][0];
96            long weight = arr[i - 1][2];
97            int originalIndex = (int) arr[i - 1][3];
98
99            int p = lowerBound(ends, i - 1, left);
100
101            for (int k = 1; k <= K; k++) {
102
103                dp[k][i] = dp[k][i - 1];
104
105                if (dp[k - 1][p] != null) {
106
107                    int[] ids = addSorted(
108                        dp[k - 1][p].ids,
109                        originalIndex
110                    );
111
112                    Node take = new Node(
113                        dp[k - 1][p].score + weight,
114                        ids
115                    );
116
117                    if (better(take, dp[k][i])) {
118                        dp[k][i] = take;
119                    }
120                }
121            }
122        }
123
124        Node answer = null;
125
126        for (int k = 1; k <= K; k++) {
127            if (better(dp[k][n], answer)) {
128                answer = dp[k][n];
129            }
130        }
131
132        return answer.ids;
133    }
134}