// Last updated: 9/2/2026, 1:15:22 PM
1class Solution {
2    public List<Integer> remainingMethods(int n, int k, int[][] invocations) {
3        List<Integer> ll = new ArrayList<>();
4        Set<Integer> set = new HashSet<>();
5        List<Integer> list = new ArrayList<>();
6        Map<Integer,ArrayList<Integer>> map = new HashMap<>();
7        for(int i = 0 ; i < n ; i++){
8            map.put(i,new ArrayList<>());
9            set.add(i);
10        }
11        for(int i = 0 ; i < invocations.length ; i++){
12            int u = invocations[i][0];
13            int v = invocations[i][1];
14            map.get(u).add(v);
15        }
16
17        Queue<Integer> q = new LinkedList<>();
18        boolean[] visited  = new boolean[n];
19        q.add(k);
20        while(!q.isEmpty()){
21            int size = q.size();
22            while(size-- > 0){
23                int curr = q.poll();
24                if(visited[curr]) continue;
25                visited[curr] = true;
26                ll.add(curr);
27                set.remove(curr);
28                for(int nbrs : map.get(curr)){
29                    q.add(nbrs);
30                }
31            }
32        }
33
34        boolean f = false;
35        for(int i = 0 ; i < invocations.length ; i++){
36            if(!set.contains(invocations[i][1]) && set.contains(invocations[i][0])) f = true;
37        }
38
39        for(int i = 0 ; i < n ; i++) {
40            if(f) list.add(i);
41            else
42            if(set.contains(i)) list.add(i);
43        }
44        return list;
45    }
46}