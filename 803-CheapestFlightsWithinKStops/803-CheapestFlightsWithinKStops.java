// Last updated: 7/9/2026, 5:19:39 PM
class Solution {
    class Pair{
        int vtx;
        int cost;
        int k;
        public Pair(int vtx , int cost , int k){
            this.vtx = vtx;
            this.cost = cost;
            this.k = k;
        }
    }


    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        HashMap<Integer , HashMap<Integer , Integer>> map = new HashMap<>();
        for(int i = 0 ; i < n ; i++){
            map.put(i,new HashMap<>());
        }

        for(int i = 0 ; i < flights.length ; i++){
            map.get(flights[i][0]).put(flights[i][1] , flights[i][2]);
        }

        int[] match = new int[n];
        Arrays.fill(match,Integer.MAX_VALUE);


        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->a.cost - b.cost);

        pq.add(new Pair(src,0,0));
        
        int ans= Integer.MAX_VALUE;
        while(!pq.isEmpty()){
            // remove
            Pair node = pq.poll();
            // ignore
            if(node.k > k+1) continue;

            if(node.k > match[node.vtx]) continue;
            match[node.vtx] = node.k;

            if(node.vtx == dst && node.k <= k+1){
                ans = Math.min(ans , node.cost);
            }
            // work
            if(!map.containsKey(node.vtx)) continue;



            for(int nbrs : map.get(node.vtx).keySet()){
                pq.add(new Pair(nbrs , node.cost + map.get(node.vtx).get(nbrs) , node.k+1 ));
            }

        }
        return ans == Integer.MAX_VALUE ? -1 : ans;

    }
}