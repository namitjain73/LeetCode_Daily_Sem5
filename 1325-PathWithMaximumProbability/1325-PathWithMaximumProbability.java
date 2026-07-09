// Last updated: 7/9/2026, 5:17:26 PM
class Pair{
    int vtx;
    double cost;
    public Pair(int vtx, double cost){
        this.vtx = vtx;
        this.cost = cost;
    }
}
class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {

        HashMap<Integer,HashMap<Integer,Double>> map = new HashMap<>();
        for(int i = 0 ;i < n ; i++){
            map.put(i,new HashMap<>());
        }
        for(int i = 0 ; i < edges.length ; i++){
            map.get(edges[i][0]).put(edges[i][1],succProb[i]);
            map.get(edges[i][1]).put(edges[i][0],succProb[i]);
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->Double.compare(b.cost,a.cost));
        HashSet<Integer> visited = new HashSet<>();
        pq.add(new Pair(start_node,1));

        while(!pq.isEmpty()){
            Pair rm = pq.poll();

            if(rm.vtx == end_node) return rm.cost;
            if(visited.contains(rm.vtx)) continue;
            visited.add(rm.vtx);

            for(int nbrs : map.get(rm.vtx).keySet()){
                if(!visited.contains(nbrs)){
                    pq.add(new Pair(nbrs , rm.cost * map.get(rm.vtx).get(nbrs)));
                }
            }
        }
        return 0;
    }
}