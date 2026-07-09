// Last updated: 7/9/2026, 5:17:05 PM
class Solution {
    int[] R = {0,-1,0,1};
    int[] C = {-1,0,1,0};
    int n;
    int m;
    public class Pair{
        int r;
        int c;
        int step;
        int stop;
        public Pair(int r, int c, int step, int stop){
            this.r = r;
            this.c = c;
            this.step = step;
            this.stop = stop;
        }
    }
    public int shortestPath(int[][] grid, int k) {
        n = grid.length;
        m = grid[0].length;
       return bfs(grid,k);
    }
    public int bfs(int[][] grid, int k){
        Queue<Pair> q = new LinkedList<>();
        int[][][] vis = new int[n][m][k+1];
        q.add(new Pair(0,0,0,0));
        vis[0][0][0] = 1;
        while(!q.isEmpty()){
            Pair rv = q.poll();
            int r = rv.r;
            int c = rv.c;
            int step = rv.step;
            int stop = rv.stop;
            if(r == n-1 && c == m-1){
                return step;
            }
            for(int i = 0; i<4; i++){
                int cr = r+R[i];
                int cc = c+C[i];
                if(cr >= 0 && cr < n && cc >= 0 && cc < m && vis[cr][cc][stop] == 0){
                    int s = stop;
                    if(grid[cr][cc] == 1 && stop == k){
                        continue;
                    }
                    else if(grid[cr][cc] == 1&& stop < k ){
                          s = stop+1;
                    }
                    q.add(new Pair(cr,cc,step+1,s));
                    vis[cr][cc][stop] = 1;
                }
            }
        }
        return -1;
    }
}