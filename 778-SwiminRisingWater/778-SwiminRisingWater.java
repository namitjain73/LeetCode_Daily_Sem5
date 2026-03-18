// Last updated: 3/18/2026, 11:42:42 AM
1class Solution {
2    public int swimInWater(int[][] grid) {
3        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[2]-b[2]);
4        int n = grid.length;
5        boolean[][] visited = new boolean[n][n];
6        pq.add(new int[]{0,0,grid[0][0]});
7
8        int[] a = {1,-1,0,0};
9        int[] b = {0,0,1,-1};
10
11        while(!pq.isEmpty()){
12            int[] curr = pq.poll();
13            int x = curr[0];
14            int y = curr[1];
15            int c = curr[2];
16
17            if(x == n-1 && y == n-1) return c;
18
19            if(visited[x][y]) continue;
20            visited[x][y] = true;
21
22
23            for(int i = 0 ; i < 4 ; i++){
24                int nx = a[i] + x;
25                int ny = b[i] + y;
26                if(nx >=0 && ny >= 0 && nx < n && ny < n){
27                    pq.add(new int[]{nx,ny,Math.max(c , grid[nx][ny])});
28                }
29            }
30        }
31        return -1;
32    }
33}