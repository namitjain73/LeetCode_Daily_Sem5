// Last updated: 7/9/2026, 5:12:40 PM
class Pair{
    int vtx;
    int cost;
    public Pair(int vtx , int cost){
        this.vtx = vtx;
        this.cost = cost;
    }
}
class Solution {
    public int secondMinimum(int n, int[][] edges, int time, int change) {
        HashMap<Integer,List<Integer>> map = new HashMap<>();
        for(int i = 0 ; i <= n ; i++){
            map.put(i,new ArrayList<>());
        }

        for(int i = 0 ; i < edges.length ; i++){
            map.get(edges[i][0]).add(edges[i][1]);
            map.get(edges[i][1]).add(edges[i][0]);
        }

        PriorityQueue<Pair> pq= new PriorityQueue<>((a,b)->a.cost-b.cost);
        pq.add(new Pair(1,0));
        int[][]dist = new int[n+1][2];
        for(int[] d : dist) Arrays.fill(d , Integer.MAX_VALUE);
        dist[1][0] = 0;


        while(!pq.isEmpty()){
            Pair rm= pq.poll();

            int  nt = rm.cost;
            if((nt/change)%2 == 1){
                nt = ((nt/change)+1)*change;
            }
            nt += time;

            if(!map.containsKey(rm.vtx)) continue;
            for(int nbrs :map.get(rm.vtx)){
                if(dist[nbrs][0] > nt){
                    dist[nbrs][1] = dist[nbrs][0];
                    dist[nbrs][0] = nt;
                    pq.add(new Pair(nbrs , nt));
                }else if(dist[nbrs][0] < nt && dist[nbrs][1] > nt){
                    dist[nbrs][1] = nt;
                    pq.add(new Pair(nbrs,nt));
                }
            }
        }
        for(int i = 0 ;i <= n ; i++){
            System.out.println(dist[i][0] + " " + dist[i][1]);
        }
        return dist[n][1];
    }
}