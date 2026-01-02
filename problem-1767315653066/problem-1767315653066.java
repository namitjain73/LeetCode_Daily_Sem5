// Last updated: 1/2/2026, 6:30:53 AM
1class Solution {
2    public List<Integer> eventualSafeNodes(int[][] graph) {
3        int n = graph.length;
4        HashMap<Integer , List<Integer>> map = new HashMap<>();
5        for(int i = 0 ; i < n ; i++){
6            map.put(i , new ArrayList<>());
7        }
8
9        int[] indeg = new int[n];
10
11        for(int i = 0 ; i < n ; i++){
12            for(int j=0; j < graph[i].length ; j++){
13                map.get(graph[i][j]).add(i);
14                indeg[i]++;
15            }
16        }
17
18        List<Integer> ans = new ArrayList<>();
19
20        Queue<Integer> q = new LinkedList<>();
21        HashSet<Integer> visited= new HashSet<>();
22        for(int i = 0 ; i < n ; i++){
23            if(indeg[i] == 0) q.add(i);
24        }
25
26        while(!q.isEmpty()){
27            int node = q.poll();
28
29            if(visited.contains(node)) continue;
30            visited.add(node);
31            ans.add(node);
32
33            for(int i : map.get(node)){
34                if(!visited.contains(i)){
35                    indeg[i]--;
36                    if(indeg[i] == 0) q.add(i);
37                }
38            }
39        }
40        Collections.sort(ans);
41        return ans;               
42    }
43}