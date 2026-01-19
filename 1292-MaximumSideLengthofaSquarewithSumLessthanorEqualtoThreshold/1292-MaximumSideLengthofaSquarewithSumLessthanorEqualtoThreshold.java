// Last updated: 1/20/2026, 1:30:22 AM
1class Solution {
2    public int maxSideLength(int[][] mat, int threshold) {
3        int m = mat.length;
4        int n = mat[0].length;
5        
6        int[][] P = new int[m + 1][n + 1];
7        
8        for (int i = 1; i <= m; i++) {
9            for (int j = 1; j <= n; j++) {
10                P[i][j] = mat[i-1][j-1] + P[i-1][j] + P[i][j-1] - P[i-1][j-1];
11            }
12        }
13        
14        int maxSide = 0;
15        
16        for (int i = 1; i <= m; i++) {
17            for (int j = 1; j <= n; j++) {
18                int len = maxSide + 1;
19                
20                if (i >= len && j >= len) {
21                    int r1 = i - len + 1;
22                    int c1 = j - len + 1;
23                    int total = P[i][j] - P[r1-1][j] - P[i][c1-1] + P[r1-1][c1-1];
24                    
25                    if (total <= threshold) {
26                        maxSide++;
27                    }
28                }
29            }
30        }
31        
32        return maxSide;
33    }
34}