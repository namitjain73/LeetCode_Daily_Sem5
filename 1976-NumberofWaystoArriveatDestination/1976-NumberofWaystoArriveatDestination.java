// Last updated: 1/4/2026, 11:12:30 PM
1class  Pair{
2    int vtx;
3    long cost;
4    public Pair(int vtx , long cost){
5        this.vtx = vtx;
6        this.cost = cost;
7    }
8}
9class Solution {
10    public int countPaths(int n, int[][] roads) {
11        int mod = 1_000_000_007;
12        HashMap<Integer,HashMap<Integer,Long>> map = new HashMap<>();
13        for(int i = 0 ; i < n ; i++){
14            map.put(i,new HashMap<>());
15        }
16
17        for(int i= 0 ; i < roads.length ; i++){
18            int u = roads[i][0];
19            int v = roads[i][1];
20            long c = roads[i][2];
21            map.get(u).put(v,c);
22            map.get(v).put(u,c);
23        }
24
25
26        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->Long.compare(a.cost,b.cost));
27        long[] dist = new long[n];
28        int[] ways = new int[n];
29        Arrays.fill(dist , Long.MAX_VALUE);
30        dist[0] = 0;
31        ways[0] = 1;
32        pq.add(new Pair(0,0));
33        while(!pq.isEmpty()){
34            Pair rm = pq.poll();
35
36            if(dist[rm.vtx] < rm.cost) continue;
37
38            if(!map.containsKey(rm.vtx)) continue;
39
40            for(int nbrs : map.get(rm.vtx).keySet()){
41                long nc = rm.cost + map.get(rm.vtx).get(nbrs);
42                if(dist[nbrs] > nc){
43                    dist[nbrs] = nc;
44                    ways[nbrs] = ways[rm.vtx];
45                    pq.add(new Pair(nbrs , nc));
46                }else if(dist[nbrs] ==nc){
47                    ways[nbrs] = (ways[nbrs] + ways[rm.vtx]) % mod;
48                }
49            }
50        }
51        return ways[n-1];
52    }
53}