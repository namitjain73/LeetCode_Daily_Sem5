// Last updated: 12/31/2025, 3:40:13 AM
1class Solution {
2    public boolean validPath(int n, int[][] edges, int source, int destination) {
3        HashMap<Integer,List<Integer>> map = new HashMap<>();
4        for(int i = 0 ;i < n ; i++){
5            map.put(i,new ArrayList<>());
6        }
7        for(int i = 0 ; i < edges.length ; i++){
8            map.get(edges[i][0]).add(edges[i][1]);
9            map.get(edges[i][1]).add(edges[i][0]);
10        }
11
12        Queue<Integer> q = new LinkedList<>();
13        HashSet<Integer> visited = new HashSet<>();
14        q.add(source);
15
16        while(!q.isEmpty()){
17            int node = q.poll();
18
19            if(visited.contains(node)) continue;
20            if(node == destination) return true;
21            visited.add(node);
22
23            for(int nbrs : map.get(node)){
24                if(!visited.contains(nbrs)){
25                    q.add(nbrs);
26                }
27            }
28        }
29        return false;
30    }
31}