// Last updated: 1/3/2026, 8:04:30 AM
1class Pair{
2    int vtx;
3    int dis;
4    public Pair(int vtx , int dis){
5        this.vtx = vtx;
6        this.dis = dis;
7    }
8}
9class Solution {
10    public boolean possibleBipartition(int n, int[][] dislikes) {
11    List<Integer>[] graph = new ArrayList[n + 1];
12    for (int i = 1; i <= n; i++) {
13        graph[i] = new ArrayList<>();
14    }
15
16    for (int[] d : dislikes) {
17        graph[d[0]].add(d[1]);
18        graph[d[1]].add(d[0]);
19    }
20
21    HashMap<Integer,Integer> visited = new HashMap<>();
22        Queue<Pair> q= new LinkedList<>();
23
24        for(int i = 1 ; i <= n ; i++){
25            if(visited.containsKey(i)) continue;
26            q.add(new Pair(i,0));
27            while(!q.isEmpty()){
28                Pair rm = q.poll();
29
30                if(visited.containsKey(rm.vtx)){
31                    if(visited.get(rm.vtx) != rm.dis) return false;
32                    continue;
33                }
34
35                visited.put(rm.vtx , rm.dis);
36
37                for(int nbrs : graph[rm.vtx]){
38                    if(!visited.containsKey(nbrs)){
39                        q.add(new Pair(nbrs,rm.dis+1));
40                    }
41                }
42            }
43        }
44        return true;
45    }
46}