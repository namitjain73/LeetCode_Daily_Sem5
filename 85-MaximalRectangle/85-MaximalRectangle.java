// Last updated: 2/23/2026, 2:31:13 AM
1class Solution {
2    public int maximalRectangle(char[][] matrix) {
3        int m = matrix.length, n = matrix[0].length, ans = 0;
4        int[]hist = new int[n];
5
6        for(int i=0;i<m;i++){
7            for(int j=0;j<n;j++){
8                if(matrix[i][j]!='0')hist[j]+=1;
9                else hist[j] = 0;
10            }
11            int area = area(hist);
12            ans = Math.max(ans, area);
13        }
14
15        return ans;
16       
17    }
18
19    public static int area(int[] heights) {
20        int n = heights.length;
21        int maxArea = 0;
22        Stack<Integer> stack = new Stack<>();
23
24        for (int i = 0; i <= n; i++) {
25            int h = (i == n) ? 0 : heights[i];
26            while (!stack.isEmpty() && h < heights[stack.peek()]) {
27                int height = heights[stack.pop()];
28                int width = stack.isEmpty() ? i : i - stack.peek() - 1;
29                maxArea = Math.max(maxArea, height * width);
30            }
31            stack.push(i);
32        }
33
34        return maxArea;
35    }
36}