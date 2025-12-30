// Last updated: 12/31/2025, 2:51:56 AM
1class Pair{
2    int r;
3    int c;
4    int cost;
5    public Pair(int r , int c, int cost){
6        this.r = r;
7        this.c = c;
8        this.cost = cost;
9    }
10}
11class Solution {
12    public int[][] highestPeak(int[][] grid) {
13        int r = grid.length;
14        int c = grid[0].length;
15        int[][] dist  = new int[r][c];
16        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->a.cost-b.cost);
17
18        for(int i = 0 ; i < r; i++){
19            for(int j = 0 ; j < c ; j++){
20                if(grid[i][j] ==1){
21                    pq.add(new Pair(i,j,0));
22                    dist[i][j] = 0;
23                }else{
24                    dist[i][j] = Integer.MAX_VALUE;
25                }
26            }
27        }
28        int[] a ={1,-1,0,0};
29        int[] b = {0,0,1,-1};
30        while(!pq.isEmpty()){
31            Pair rm = pq.poll();
32            if(dist[rm.r][rm.c] < rm.cost) continue;
33
34            for(int k = 0 ;k < 4 ; k++){
35                int nx = rm.r + a[k];
36                int ny = rm.c + b[k];
37
38                if(nx >= 0 && ny >= 0 && nx < r && ny < c){
39                    if(dist[nx][ny] > rm.cost+1){
40                        dist[nx][ny] = rm.cost+1;
41                        pq.add(new Pair(nx , ny , rm.cost+1));
42                    }
43                }
44            }
45        }
46        return dist;
47    }
48}