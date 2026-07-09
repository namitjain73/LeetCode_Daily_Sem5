// Last updated: 7/9/2026, 5:20:06 PM
class Solution {
    class Pair{
        int vtx;
        int cost;
        public Pair(int vtx , int cost){
            this.vtx = vtx;
            this.cost = cost;
        }
    }


    public int networkDelayTime(int[][] times, int n, int k) {
        HashMap<Integer , HashMap<Integer , Integer>> map = new HashMap<>();
        for(int i = 1 ; i <= n ; i++){
            map.put(i,new HashMap<>());
        }

        for(int i = 0 ; i < times.length ; i++){
            map.get(times[i][0]).put(times[i][1] , times[i][2]);
        }


        HashSet<Integer> visited = new HashSet<>();
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->a.cost - b.cost);
        pq.add(new Pair(k,0));
        List<Integer> list = new ArrayList<>();

        while(!pq.isEmpty()){
            // remove
            Pair node = pq.poll();
            // ignore
            if(visited.contains(node.vtx)) continue;
            // self work
            visited.add(node.vtx);
            list.add(node.cost);

            if(!map.containsKey(node.vtx)) continue;

            for(int nbrs : map.get(node.vtx).keySet()){
                if(!visited.contains(nbrs)){
                    pq.add(new Pair(nbrs , node.cost + map.get(node.vtx).get(nbrs)));
                }
            }

        }
        return list.size() == n ? max(list) : -1;
    }
    public int max(List<Integer> ll){
        int max = -1;
        for(int i : ll) max=  Math.max(max,i);
        return max;
    }
}