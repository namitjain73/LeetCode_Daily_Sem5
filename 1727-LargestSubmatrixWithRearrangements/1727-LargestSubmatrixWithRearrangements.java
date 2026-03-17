// Last updated: 3/18/2026, 1:43:41 AM
1class Solution {
2    public int largestSubmatrix(int[][] matrix) {
3        int m = matrix.length, n = matrix[0].length;
4        int max_area = 0;
5        
6        for (int i = 0; i < m; i++) {
7        	for (int j = 0; j < n; j++) {
8        		if (matrix[i][j] == 1 && i > 0) {
9        			matrix[i][j] = matrix[i - 1][j] + 1;
10        		}
11        	} 
12        	
13        	int[] heights = matrix[i].clone();
14        	
15        	Arrays.sort(heights);
16        	
17        	for (int j = n - 1; j >= 0; j--) {
18        		if (heights[j] == 0) break;
19        		
20        		int width = n - j;
21        		int height = heights[j];
22        		
23        		max_area = Math.max(max_area, width * height);
24        	}
25        }
26        
27       return max_area;
28    }
29}