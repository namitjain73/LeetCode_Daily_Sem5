// Last updated: 8/24/2026, 12:46:56 PM
1class Solution {
2    public boolean canFinish(int n, int[][] prerequisites) {
3        Map<Integer,ArrayList<Integer>> adj = new HashMap<>();
4        int[] indeg = new int[n];
5
6        for(int i = 0 ; i < n ; i++) adj.put(i , new ArrayList<>());
7        for(int i = 0 ; i < prerequisites.length ; i++){
8            int u = prerequisites[i][0];
9            int v = prerequisites[i][1];
10            adj.get(u).add(v);
11            indeg[v]++;
12        }
13
14        boolean[] visited = new boolean[n];
15        Queue<Integer> q = new LinkedList<>();
16        for(int i = 0 ; i < n ; i++){
17            if(indeg[i] == 0) q.add(i);
18        }
19
20        while(!q.isEmpty()){
21            int node = q.poll();
22            n--;
23            for(int nbrs : adj.get(node)){
24                indeg[nbrs]--;
25                if(indeg[nbrs] == 0){
26                    q.add(nbrs);
27                }
28            }
29        }
30
31        for(int i = 0; i < n ; i++){
32            System.out.println(indeg[i]);
33        }
34        return n == 0;
35    }
36}