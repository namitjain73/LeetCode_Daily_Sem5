// Last updated: 8/24/2026, 7:31:21 PM
1class Solution {
2    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
3        List<Integer> ll = new ArrayList<>();
4        if(n==1) {
5            ll.add(0);
6            return ll;
7        }
8
9        Map<Integer,ArrayList<Integer>> map = new HashMap<>();
10        int[] indeg = new int[n];
11        for(int[] i : edges){
12            indeg[i[0]]++;
13            indeg[i[1]]++;
14            map.putIfAbsent(i[0],new ArrayList<>());
15            map.putIfAbsent(i[1],new ArrayList<>());
16            map.get(i[0]).add(i[1]);
17            map.get(i[1]).add(i[0]);
18        }
19
20        Queue<Integer> q = new LinkedList<>();
21        for(int i = 0 ; i < n ; i++){
22            if(indeg[i] == 1){
23                q.add(i);
24            }
25        }
26        int action = 0;
27        while(n - action > 2){
28            int size = q.size();
29            action += size;
30            for(int i = 0 ; i < size ; i++){
31                int curr = q.poll();
32                for(int nbrs : map.get(curr)){
33                    indeg[nbrs]--;
34                    if(indeg[nbrs] == 1){
35                        q.add(nbrs);
36                    }
37                }
38            }
39        }
40        ll.addAll(q);
41        return ll;
42    }
43}