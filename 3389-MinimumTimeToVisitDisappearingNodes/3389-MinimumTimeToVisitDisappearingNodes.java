// Last updated: 7/9/2026, 5:05:25 PM
class Solution {
    class Pair{
        int vtx;
        int cost;
        public Pair(int vtx , int cost){
            this.vtx = vtx;
            this.cost = cost;
        }
    }
    public int[] minimumTime(int n, int[][] edges, int[] dis) {
        Map<Integer,Map<Integer,Integer>> map =  new HashMap<>();
        for(int i = 0  ;i < n ; i++){
            map.put(i , new HashMap<>());
        }
        for(int i = 0 ; i < edges.length ; i++){
            int u = edges[i][0];
            int v = edges[i][1];
            int c = edges[i][2];

            if(u == v) continue;
            if(map.get(u).containsKey(v)) { 
                if(map.get(u).get(v) > c){ 
                    map.get(u).put(v,c); 
                    map.get(v).put(u,c); 
                } 
                continue;
            }

            map.get(u).put(v,c);
            map.get(v).put(u,c);
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->a.cost-b.cost);
        int[] ans = new int[n];
        Arrays.fill(ans,-1);
        ans[0] = 0;
        pq.add(new Pair(0,0));

        while(!pq.isEmpty()){
            Pair rm = pq.poll();

            if(rm.cost > ans[rm.vtx]) continue;


            for(int nbrs : map.get(rm.vtx).keySet()){
                int nc  = rm.cost + map.get(rm.vtx).get(nbrs);

                if(nc >= dis[nbrs]) continue;
                if(ans[nbrs] == -1 || ans[nbrs] > nc){
                    pq.add(new Pair(nbrs,nc));
                    ans[nbrs] = nc;
                }
            }
        }
        return ans;
    }
}