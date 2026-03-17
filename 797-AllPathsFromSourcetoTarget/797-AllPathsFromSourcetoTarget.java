// Last updated: 3/17/2026, 3:02:14 PM
1class Solution {
2    int[] R = {0,-1,0,1};
3    int[] C = {-1,0,1,0};
4    int n;
5    int m;
6    public class Pair{
7        int r;
8        int c;
9        int step;
10        int stop;
11        public Pair(int r, int c, int step, int stop){
12            this.r = r;
13            this.c = c;
14            this.step = step;
15            this.stop = stop;
16        }
17    }
18    public int shortestPath(int[][] grid, int k) {
19        n = grid.length;
20        m = grid[0].length;
21       return bfs(grid,k);
22    }
23    public int bfs(int[][] grid, int k){
24        Queue<Pair> q = new LinkedList<>();
25        int[][][] vis = new int[n][m][k+1];
26        q.add(new Pair(0,0,0,0));
27        vis[0][0][0] = 1;
28        while(!q.isEmpty()){
29            Pair rv = q.poll();
30            int r = rv.r;
31            int c = rv.c;
32            int step = rv.step;
33            int stop = rv.stop;
34            if(r == n-1 && c == m-1){
35                return step;
36            }
37            for(int i = 0; i<4; i++){
38                int cr = r+R[i];
39                int cc = c+C[i];
40                if(cr >= 0 && cr < n && cc >= 0 && cc < m && vis[cr][cc][stop] == 0){
41                    int s = stop;
42                    if(grid[cr][cc] == 1 && stop == k){
43                        continue;
44                    }
45                    else if(grid[cr][cc] == 1&& stop < k ){
46                          s = stop+1;
47                    }
48                    q.add(new Pair(cr,cc,step+1,s));
49                    vis[cr][cc][stop] = 1;
50                }
51            }
52        }
53        return -1;
54    }
55}