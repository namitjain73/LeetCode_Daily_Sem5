// Last updated: 12/30/2025, 3:23:17 PM
1class Pair{
2    int row;
3    int col;
4    int val;
5    public Pair(int row , int col , int val){
6        this.row = row;
7        this.col = col;
8        this.val = val;
9    }
10}
11
12class Solution {
13    public int[][] updateMatrix(int[][] mat) {
14        int n = mat.length;
15        int m = mat[0].length;
16        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->a.val-b.val);
17        int[][] dist = new int[n][m];
18
19
20        for(int i = 0 ; i < n ; i++){
21            for(int j = 0 ; j < m ; j++){
22                if(mat[i][j] == 0){
23                    pq.add(new Pair(i,j,0));
24                    dist[i][j] = 0;
25                }else{
26                    dist[i][j] = Integer.MAX_VALUE;
27                }
28            }
29        }
30
31
32
33        int[] a = {1,-1,0,0};
34        int[] b = {0,0,1,-1};
35
36        while(!pq.isEmpty()){
37            Pair node = pq.poll();
38            if(node.val > dist[node.row][node.col]) continue;
39
40            for(int i = 0 ; i < 4 ; i++){
41                int nx = node.row + a[i];
42                int ny = node.col + b[i];
43
44                if(nx >= 0 && ny >= 0 && nx < n && ny < m){
45                    if(node.val+1 < dist[nx][ny]){
46                        pq.add(new Pair(nx , ny , node.val+1));
47                        dist[nx][ny] = node.val + 1;
48                    }
49                }
50            }
51        }
52        return dist;
53    }
54}