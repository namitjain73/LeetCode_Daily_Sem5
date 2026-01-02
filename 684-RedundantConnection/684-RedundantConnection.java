// Last updated: 1/2/2026, 6:36:54 AM
1class Solution {
2public class Prims_Algo {
3    public ArrayList<String> ll = new ArrayList<>();
4    private HashMap<Integer,HashMap<Integer,Integer>> map;
5	public Prims_Algo(int v) {
6		map = new HashMap<>();
7		for(int i = 1 ; i <= v ; i++) {
8			map.put(i,new HashMap<>());
9		}
10		
11	}
12	
13	
14	public void AddEdge(int v1 , int v2 , int cost) {
15		map.get(v1).put(v2,cost);
16		map.get(v2).put(v1, cost);
17	}
18	
19	class PrimsPair{
20		int vtx;
21		int acq_vtx;
22		int cost;
23		public PrimsPair(int vtx , int acq_vtx , int cost) {
24			this.vtx = vtx;
25			this.acq_vtx = acq_vtx;
26			this.cost = cost;
27		}
28		
29		@Override
30		public String toString() {
31			return vtx + " " + acq_vtx;
32		}
33	}
34
35	public ArrayList<String> PrimsAlgorithm() {
36		PriorityQueue<PrimsPair> pq = new PriorityQueue<>((a,b)->a.cost - b.cost);
37		HashSet<Integer> visited = new HashSet<>();
38		pq.add(new PrimsPair(1,1,0));
39		while(!pq.isEmpty()) {
40//			1. remove
41			PrimsPair rp = pq.poll();
42//			2. Ignore if Already visited
43			if(visited.contains(rp.vtx)) continue;
44//			3. marked visited
45			visited.add(rp.vtx);
46//			4. self work
47            ll.add(rp.toString());
48            ll.add(rp.acq_vtx + " " + rp.vtx);
49//			5. add nbrs
50			for(int nbrs : map.get(rp.vtx).keySet()) {
51				if(!visited.contains(nbrs)) {
52					int cost = map.get(rp.vtx).get(nbrs);
53					pq.add(new PrimsPair(nbrs,rp.vtx,cost));
54				}
55			}
56		}
57        return ll;
58	}}  
59
60    public int[] findRedundantConnection(int[][] edges) {
61        int n = edges.length;
62        Prims_Algo pq = new Prims_Algo(n);
63        for(int i = 0 ; i < n;  i++){
64            int v1 = edges[i][0];
65            int v2 = edges[i][1];
66            pq.AddEdge(v1, v2, i);
67        }
68		
69		ArrayList<String> ll = pq.PrimsAlgorithm();
70        int[] ans = new int[2];
71        System.out.println(ll);
72        for(int[] i : edges){
73            String s = i[0] + " " + i[1];
74            if(!ll.contains(s)){
75                ans[0] = i[0];
76                ans[1] = i[1];
77            }
78        }
79        return ans;
80    }
81}