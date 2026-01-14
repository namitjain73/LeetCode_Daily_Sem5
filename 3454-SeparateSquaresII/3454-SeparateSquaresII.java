// Last updated: 1/15/2026, 1:11:03 AM
1class Solution {
2    static class Event {
3        long y;
4        int event_type;
5        long x_left, x_right;
6        Event(long y, int event_type, long x_left, long x_right) {
7            this.y = y; this.event_type = event_type; this.x_left = x_left; this.x_right = x_right;
8        }
9    }
10
11    static class Slice {
12        long start_y, height, width;
13        Slice(long start_y, long height, long width) {
14            this.start_y = start_y; this.height = height; this.width = width;
15        }
16    }
17
18    private long union_width(ArrayList<long[]> intervals) {
19        intervals.sort((a, b) -> {
20            if (a[0] != b[0]) return Long.compare(a[0], b[0]);
21            return Long.compare(a[1], b[1]);
22        });
23
24        long total_width = 0;
25        long rightmost = (long)-1e18;
26
27        for (long[] it : intervals) {
28            long left = it[0], right = it[1];
29            if (left > rightmost) {
30                total_width += right - left;
31                rightmost = right;
32            } else if (right > rightmost) {
33                total_width += right - rightmost;
34                rightmost = right;
35            }
36        }
37        return total_width;
38    }
39
40    public double separateSquares(int[][] squares) {
41        ArrayList<Event> events = new ArrayList<>();
42
43        for (int[] sq : squares) {
44            long x = sq[0], y = sq[1], length = sq[2];
45            events.add(new Event(y, 1, x, x + length));
46            events.add(new Event(y + length, -1, x, x + length));
47        }
48
49        events.sort((a, b) -> {
50            if (a.y != b.y) return Long.compare(a.y, b.y);
51            if (a.event_type != b.event_type) return Integer.compare(a.event_type, b.event_type);
52            if (a.x_left != b.x_left) return Long.compare(a.x_left, b.x_left);
53            return Long.compare(a.x_right, b.x_right);
54        });
55
56        ArrayList<long[]> active_intervals = new ArrayList<>();
57        long prev_y = events.get(0).y;
58        long total_area = 0;
59        ArrayList<Slice> horizontal_slices = new ArrayList<>();
60
61        for (Event e : events) {
62            long y = e.y;
63            int event_type = e.event_type;
64            long x_left = e.x_left;
65            long x_right = e.x_right;
66
67            if (y > prev_y && !active_intervals.isEmpty()) {
68                long height = y - prev_y;
69
70                ArrayList<long[]> tmp = new ArrayList<>(active_intervals.size());
71                for (long[] it : active_intervals) tmp.add(new long[]{it[0], it[1]});
72                long width = union_width(tmp);
73
74                horizontal_slices.add(new Slice(prev_y, height, width));
75                total_area += height * width;
76            }
77
78            if (event_type == 1) {
79                active_intervals.add(new long[]{x_left, x_right});
80            } else {
81                for (int i = 0; i < active_intervals.size(); i++) {
82                    long[] it = active_intervals.get(i);
83                    if (it[0] == x_left && it[1] == x_right) {
84                        active_intervals.remove(i);
85                        break;
86                    }
87                }
88            }
89
90            prev_y = y;
91        }
92
93        double half = total_area / 2.0;
94        double accumulated = 0.0;
95
96        for (Slice sl : horizontal_slices) {
97            long start_y = sl.start_y;
98            long height = sl.height;
99            long width = sl.width;
100
101            double slice_area = (double)height * (double)width;
102            if (accumulated + slice_area >= half) {
103                return (double)start_y + (half - accumulated) / (double)width;
104            }
105            accumulated += slice_area;
106        }
107
108        return (double)prev_y;
109    }
110}