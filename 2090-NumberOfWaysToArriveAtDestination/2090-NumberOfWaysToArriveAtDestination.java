// Last updated: 7/9/2026, 5:13:28 PM
class  Pair{
    int vtx;
    long cost;
    public Pair(int vtx , long cost){
        this.vtx = vtx;
        this.cost = cost;
    }
}
class Solution {
    public int countPaths(int n, int[][] roads) {
        int mod = 1_000_000_007;
        HashMap<Integer,HashMap<Integer,Long>> map = new HashMap<>();
        for(int i = 0 ; i < n ; i++){
            map.put(i,new HashMap<>());
        }

        for(int i= 0 ; i < roads.length ; i++){
            int u = roads[i][0];
            int v = roads[i][1];
            long c = roads[i][2];
            map.get(u).put(v,c);
            map.get(v).put(u,c);
        }


        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->Long.compare(a.cost,b.cost));
        long[] dist = new long[n];
        int[] ways = new int[n];
        Arrays.fill(dist , Long.MAX_VALUE);
        dist[0] = 0;
        ways[0] = 1;
        pq.add(new Pair(0,0));
        while(!pq.isEmpty()){
            Pair rm = pq.poll();

            if(dist[rm.vtx] < rm.cost) continue;

            if(!map.containsKey(rm.vtx)) continue;

            for(int nbrs : map.get(rm.vtx).keySet()){
                long nc = rm.cost + map.get(rm.vtx).get(nbrs);
                if(dist[nbrs] > nc){
                    dist[nbrs] = nc;
                    ways[nbrs] = ways[rm.vtx];
                    pq.add(new Pair(nbrs , nc));
                }else if(dist[nbrs] ==nc){
                    ways[nbrs] = (ways[nbrs] + ways[rm.vtx]) % mod;
                }
            }
        }
        return ways[n-1];
    }
}