// Last updated: 12/30/2025, 1:06:29 PM
1class Solution {
2    class Pair{
3        int vtx;
4        int cost;
5        public Pair(int vtx , int cost){
6            this.vtx = vtx;
7            this.cost = cost;
8        }
9    }
10
11
12    public int networkDelayTime(int[][] times, int n, int k) {
13        HashMap<Integer , HashMap<Integer , Integer>> map = new HashMap<>();
14        for(int i = 1 ; i <= n ; i++){
15            map.put(i,new HashMap<>());
16        }
17
18        for(int i = 0 ; i < times.length ; i++){
19            map.get(times[i][0]).put(times[i][1] , times[i][2]);
20        }
21
22
23        HashSet<Integer> visited = new HashSet<>();
24        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->a.cost - b.cost);
25        pq.add(new Pair(k,0));
26        List<Integer> list = new ArrayList<>();
27
28        while(!pq.isEmpty()){
29            // remove
30            Pair node = pq.poll();
31            // ignore
32            if(visited.contains(node.vtx)) continue;
33            // self work
34            visited.add(node.vtx);
35            list.add(node.cost);
36
37            if(!map.containsKey(node.vtx)) continue;
38
39            for(int nbrs : map.get(node.vtx).keySet()){
40                if(!visited.contains(nbrs)){
41                    pq.add(new Pair(nbrs , node.cost + map.get(node.vtx).get(nbrs)));
42                }
43            }
44
45        }
46        return list.size() == n ? max(list) : -1;
47    }
48    public int max(List<Integer> ll){
49        int max = -1;
50        for(int i : ll) max=  Math.max(max,i);
51        return max;
52    }
53}