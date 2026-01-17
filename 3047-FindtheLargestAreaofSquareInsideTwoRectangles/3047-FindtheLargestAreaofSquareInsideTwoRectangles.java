// Last updated: 1/18/2026, 2:48:39 AM
1class Solution {
2    public long largestSquareArea(int[][] bottomLeft, int[][] topRight) {
3        long maxSide = 0;
4        int n = bottomLeft.length;
5
6        for (int i = 0; i < n; i++) {
7            for (int j = i + 1; j < n; j++) {
8                // Find intersection boundaries
9                // Use Math.max for lower bounds (left, bottom)
10                // Use Math.min for upper bounds (right, top)
11                int x1 = Math.max(bottomLeft[i][0], bottomLeft[j][0]);
12                int y1 = Math.max(bottomLeft[i][1], bottomLeft[j][1]);
13                int x2 = Math.min(topRight[i][0], topRight[j][0]);
14                int y2 = Math.min(topRight[i][1], topRight[j][1]);
15
16                // Width and Height of the intersection rectangle
17                long width = x2 - x1;
18                long height = y2 - y1;
19
20                // If valid intersection (width and height > 0)
21                if (width > 0 && height > 0) {
22                    long side = Math.min(width, height);
23                    maxSide = Math.max(maxSide, side);
24                }
25            }
26        }
27
28        return maxSide * maxSide;
29    }
30}