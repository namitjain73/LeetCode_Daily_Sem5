// Last updated: 7/9/2026, 5:15:14 PM
public class Solution {
    public int minimumEffortPath(int[][] heights) {
        int rows = heights.length;
        int cols = heights[0].length;
        int[][] dist = new int[rows][cols];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        pq.add(new int[]{0, 0, 0});
        
        for(int[] d : dist) Arrays.fill(d , Integer.MAX_VALUE);
        dist[0][0] = 0;
        
        int[] a = {1,-1,0,0};
        int[] b = {0,0,1,-1};
        
        while (!pq.isEmpty()) {
            int[] top = pq.poll();
            int effort = top[0];
            int x = top[1];
            int y = top[2];
            
            if (effort > dist[x][y]) continue;
            
            if (x == rows - 1 && y == cols - 1) return effort;
            
            for (int k = 0 ;  k < 4 ; k++) {
                int nx = x + a[k], ny = y + b[k];
                if (nx >= 0 && nx < rows && ny >= 0 && ny < cols) {
                    int new_effort = Math.max(effort, Math.abs(heights[x][y] - heights[nx][ny]));
                    if (new_effort < dist[nx][ny]) {
                        dist[nx][ny] = new_effort;
                        pq.add(new int[]{new_effort, nx, ny});
                    }
                }
            }
        }
        return -1;
    }
}