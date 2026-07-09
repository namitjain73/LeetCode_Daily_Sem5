// Last updated: 7/9/2026, 5:19:43 PM
class Solution {
    public int swimInWater(int[][] grid) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[2]-b[2]);
        int n = grid.length;
        boolean[][] visited = new boolean[n][n];
        pq.add(new int[]{0,0,grid[0][0]});

        int[] a = {1,-1,0,0};
        int[] b = {0,0,1,-1};

        while(!pq.isEmpty()){
            int[] curr = pq.poll();
            int x = curr[0];
            int y = curr[1];
            int c = curr[2];

            if(x == n-1 && y == n-1) return c;

            if(visited[x][y]) continue;
            visited[x][y] = true;


            for(int i = 0 ; i < 4 ; i++){
                int nx = a[i] + x;
                int ny = b[i] + y;
                if(nx >=0 && ny >= 0 && nx < n && ny < n){
                    pq.add(new int[]{nx,ny,Math.max(c , grid[nx][ny])});
                }
            }
        }
        return -1;
    }
}