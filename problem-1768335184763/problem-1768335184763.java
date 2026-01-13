// Last updated: 1/14/2026, 1:43:04 AM
1import java.util.*;
2
3class Solution {
4    public double separateSquares(int[][] squares) {
5        double totalArea = 0;
6        double low = Double.MAX_VALUE;
7        double high = Double.MIN_VALUE;
8
9        for (int[] s : squares) {
10            double y = s[1];
11            double l = s[2];
12            totalArea += l * l;
13            low = Math.min(low, y);
14            high = Math.max(high, y + l);
15        }
16
17        double targetArea = totalArea / 2.0;
18
19        for (int i = 0; i < 100; i++) {
20            double mid = low + (high - low) / 2.0;
21            double currentArea = 0;
22
23            for (int[] s : squares) {
24                double y = s[1];
25                double l = s[2];
26                
27                double hBelow = Math.max(0, Math.min(l, mid - y));
28                currentArea += hBelow * l;
29            }
30
31            if (currentArea < targetArea) {
32                low = mid;
33            } else {
34                high = mid;
35            }
36        }
37
38        return high;
39    }
40}