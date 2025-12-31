// Last updated: 12/31/2025, 11:17:12 AM
1class Solution {
2    public boolean canFinish(int v, int[][] pre) {
3        int[] indeg = new int[v];
4        List<List<Integer>>  ll = new ArrayList<>();
5        for(int i = 0 ; i < v ; i++){
6            ll.add(new ArrayList<>());
7        }
8        for(int[] i : pre){
9            ll.get(i[0]).add(i[1]);
10            indeg[i[1]]++;
11        }
12
13        int n = 0;
14        Queue<Integer> q = new LinkedList<>();
15        for(int i = 0 ; i < v ; i++){
16            if(indeg[i] == 0){
17                q.add(i);
18            }
19        }
20        while(!q.isEmpty()){
21            int rm = q.poll();
22            n++;
23            
24            for(int i : ll.get(rm)){
25                indeg[i]--;
26                if(indeg[i] == 0){
27                    q.add(i);
28                }
29            }
30        }
31
32        return n == v;
33    }
34}