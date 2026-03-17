// Last updated: 3/17/2026, 11:53:21 AM
1class Solution {
2    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
3        int n = graph.length;
4        Map<Integer,ArrayList<Integer>> map = new HashMap<>();
5        for(int i = 0 ; i < n ; i++){
6            map.put(i,new ArrayList<>());
7        }
8        for(int i = 0 ; i < n ; i++){
9            for(int j : graph[i]){
10                map.get(i).add(j);
11            }
12        }
13
14        boolean[] visited = new boolean[n];
15        List<List<Integer>> ll = new ArrayList<>();
16        List<Integer> list = new ArrayList<>();
17        list.add(0);
18        dfs(map , ll , list, visited , 0 , n-1);
19        return ll;
20    }
21    public void dfs(Map<Integer,ArrayList<Integer>> map ,List<List<Integer>> ll,List<Integer> list ,boolean[] visited , int node , int dest){
22        if(node == dest){
23            ll.add(new ArrayList<>(list));
24        }
25
26        visited[node] = true;
27        for(int nbrs : map.get(node)){
28            if(!visited[nbrs]){
29                list.add(nbrs);
30                dfs(map , ll , list , visited , nbrs , dest);
31                list.remove(list.size()-1);
32            }
33        }
34        visited[node] = false;
35    }
36}