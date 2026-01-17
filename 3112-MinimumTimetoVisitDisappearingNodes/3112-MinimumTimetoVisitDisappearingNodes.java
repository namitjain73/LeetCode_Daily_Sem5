// Last updated: 1/17/2026, 11:00:08 PM
1class Pair{
2    int vtx;
3    int cost;
4    // int req_cost;
5    public Pair(int vtx , int cost ){
6        this.vtx = vtx;
7        this.cost = cost;
8        // this.req_cost = req_cost;
9    }
10}
11class Solution {
12    public int[] minimumTime(int n, int[][] edges, int[] disappear) {
13        HashMap<Integer,HashMap<Integer,Integer>> map = new HashMap<>();
14        int[] ans = new int[n];
15        Arrays.fill(ans,-1);
16        ans[0]=0;
17        for(int i = 0 ; i <  n ; i++){
18            map.put(i,new HashMap<>());
19        }
20
21        for(int i = 0 ; i < edges.length ; i++){
22            int u = edges[i][0];
23            int v = edges[i][1];
24            int c = edges[i][2];
25            if(u ==v) continue;
26            if(map.get(u).containsKey(v)) { 
27                if(map.get(u).get(v) > c){ 
28                    map.get(u).put(v,c); 
29                    map.get(v).put(u,c); 
30                } 
31                continue;
32            }
33            map.get(u).put(v,c);
34            map.get(v).put(u,c);
35        }
36
37
38        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->a.cost-b.cost);
39        pq.add(new Pair(0,0));
40
41        while(!pq.isEmpty()){
42            Pair rm = pq.poll();
43            
44            if(rm.cost > ans[rm.vtx]) continue;
45            for(int nbrs: map.get(rm.vtx).keySet()){
46                int nt = rm.cost+ map.get(rm.vtx).get(nbrs);
47                if(nt >= disappear[nbrs]) continue;
48                if(ans[nbrs]== -1 || nt < ans[nbrs]){
49                    pq.add(new Pair(nbrs , nt ));
50                    ans[nbrs] = nt;
51                }
52            }
53        }
54        return ans;
55    }
56}