// Last updated: 12/30/2025, 12:49:28 PM
1class Solution {
2    class Pair{
3        int vtx;
4        int cost;
5        int k;
6        public Pair(int vtx , int cost , int k){
7            this.vtx = vtx;
8            this.cost = cost;
9            this.k = k;
10        }
11    }
12
13
14    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
15        HashMap<Integer , HashMap<Integer , Integer>> map = new HashMap<>();
16        for(int i = 0 ; i < n ; i++){
17            map.put(i,new HashMap<>());
18        }
19
20        for(int i = 0 ; i < flights.length ; i++){
21            map.get(flights[i][0]).put(flights[i][1] , flights[i][2]);
22        }
23
24        int[] match = new int[n];
25        Arrays.fill(match,Integer.MAX_VALUE);
26
27
28        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->a.cost - b.cost);
29
30        pq.add(new Pair(src,0,0));
31        
32        int ans= Integer.MAX_VALUE;
33        while(!pq.isEmpty()){
34            // remove
35            Pair node = pq.poll();
36            // ignore
37            if(node.k > k+1) continue;
38
39            if(node.k > match[node.vtx]) continue;
40            match[node.vtx] = node.k;
41
42            if(node.vtx == dst && node.k <= k+1){
43                ans = Math.min(ans , node.cost);
44            }
45            // work
46            if(!map.containsKey(node.vtx)) continue;
47
48
49
50            for(int nbrs : map.get(node.vtx).keySet()){
51                pq.add(new Pair(nbrs , node.cost + map.get(node.vtx).get(nbrs) , node.k+1 ));
52            }
53
54        }
55        return ans == Integer.MAX_VALUE ? -1 : ans;
56
57    }
58}