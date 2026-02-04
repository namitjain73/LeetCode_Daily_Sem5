// Last updated: 2/4/2026, 11:58:21 PM
1class Solution {
2    class Pair{
3        int vtx;
4        int cost;
5        public Pair(int vtx , int cost){
6            this.vtx = vtx;
7            this.cost = cost;
8        }
9    }
10    public int[] minimumTime(int n, int[][] edges, int[] dis) {
11        Map<Integer,Map<Integer,Integer>> map =  new HashMap<>();
12        for(int i = 0  ;i < n ; i++){
13            map.put(i , new HashMap<>());
14        }
15        for(int i = 0 ; i < edges.length ; i++){
16            int u = edges[i][0];
17            int v = edges[i][1];
18            int c = edges[i][2];
19
20            if(u == v) continue;
21            if(map.get(u).containsKey(v)) { 
22                if(map.get(u).get(v) > c){ 
23                    map.get(u).put(v,c); 
24                    map.get(v).put(u,c); 
25                } 
26                continue;
27            }
28
29            map.get(u).put(v,c);
30            map.get(v).put(u,c);
31        }
32
33        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->a.cost-b.cost);
34        int[] ans = new int[n];
35        Arrays.fill(ans,-1);
36        ans[0] = 0;
37        pq.add(new Pair(0,0));
38
39        while(!pq.isEmpty()){
40            Pair rm = pq.poll();
41
42            if(rm.cost > ans[rm.vtx]) continue;
43
44
45            for(int nbrs : map.get(rm.vtx).keySet()){
46                int nc  = rm.cost + map.get(rm.vtx).get(nbrs);
47
48                if(nc >= dis[nbrs]) continue;
49                if(ans[nbrs] == -1 || ans[nbrs] > nc){
50                    pq.add(new Pair(nbrs,nc));
51                    ans[nbrs] = nc;
52                }
53            }
54        }
55        return ans;
56    }
57}