// Last updated: 7/9/2026, 5:14:44 PM
class Pair{
    int r;
    int c;
    int cost;
    public Pair(int r , int c, int cost){
        this.r = r;
        this.c = c;
        this.cost = cost;
    }
}
class Solution {
    public int[][] highestPeak(int[][] grid) {
        int r = grid.length;
        int c = grid[0].length;
        int[][] dist  = new int[r][c];
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->a.cost-b.cost);

        for(int i = 0 ; i < r; i++){
            for(int j = 0 ; j < c ; j++){
                if(grid[i][j] ==1){
                    pq.add(new Pair(i,j,0));
                    dist[i][j] = 0;
                }else{
                    dist[i][j] = Integer.MAX_VALUE;
                }
            }
        }
        int[] a ={1,-1,0,0};
        int[] b = {0,0,1,-1};
        while(!pq.isEmpty()){
            Pair rm = pq.poll();
            if(dist[rm.r][rm.c] < rm.cost) continue;

            for(int k = 0 ;k < 4 ; k++){
                int nx = rm.r + a[k];
                int ny = rm.c + b[k];

                if(nx >= 0 && ny >= 0 && nx < r && ny < c){
                    if(dist[nx][ny] > rm.cost+1){
                        dist[nx][ny] = rm.cost+1;
                        pq.add(new Pair(nx , ny , rm.cost+1));
                    }
                }
            }
        }
        return dist;
    }
}