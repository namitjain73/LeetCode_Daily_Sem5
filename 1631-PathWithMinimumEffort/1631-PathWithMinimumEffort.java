// Last updated: 3/17/2026, 11:34:57 AM
1public class Solution {
2    public int minimumEffortPath(int[][] heights) {
3        int rows = heights.length;
4        int cols = heights[0].length;
5        int[][] dist = new int[rows][cols];
6        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
7        pq.add(new int[]{0, 0, 0});
8        
9        for(int[] d : dist) Arrays.fill(d , Integer.MAX_VALUE);
10        dist[0][0] = 0;
11        
12        int[] a = {1,-1,0,0};
13        int[] b = {0,0,1,-1};
14        
15        while (!pq.isEmpty()) {
16            int[] top = pq.poll();
17            int effort = top[0];
18            int x = top[1];
19            int y = top[2];
20            
21            if (effort > dist[x][y]) continue;
22            
23            if (x == rows - 1 && y == cols - 1) return effort;
24            
25            for (int k = 0 ;  k < 4 ; k++) {
26                int nx = x + a[k], ny = y + b[k];
27                if (nx >= 0 && nx < rows && ny >= 0 && ny < cols) {
28                    int new_effort = Math.max(effort, Math.abs(heights[x][y] - heights[nx][ny]));
29                    if (new_effort < dist[nx][ny]) {
30                        dist[nx][ny] = new_effort;
31                        pq.add(new int[]{new_effort, nx, ny});
32                    }
33                }
34            }
35        }
36        return -1;
37    }
38}