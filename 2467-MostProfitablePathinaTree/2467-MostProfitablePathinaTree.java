// Last updated: 1/3/2026, 10:27:23 PM
1class Solution {
2    List<List<Integer>> adj;
3    int[] bobPath;
4    public int mostProfitablePath(int[][] edges, int bob, int[] amount) {
5        adj = new ArrayList<>();
6        int n = edges.length + 1;
7        for(int i = 0; i < n; i++){
8            adj.add(new ArrayList<>());
9        }
10        for(int[] e : edges){
11            adj.get(e[0]).add(e[1]);
12            adj.get(e[1]).add(e[0]);
13        }
14        bobPath = new int[n];
15        Arrays.fill(bobPath, -1);
16        ArrayList<Integer> path = new ArrayList<>();
17        findBob(path, bob, -1);
18        for(int i = 0; i < path.size(); i++){
19            bobPath[path.get(i)] = i;
20        }
21        return score(0, -1, amount, 0, 0);
22    }
23    private boolean findBob(ArrayList<Integer> path, int node, int parent){
24        if(node == 0) return true;
25        for(int nbr : adj.get(node)){
26            if(nbr != parent){
27                path.add(node);
28                if(findBob(path, nbr, node)) return true;
29                path.remove(path.size() - 1);
30            }
31        }
32        return false;
33    }
34    private int score(int node, int parent, int[] amount, int time, int curr){
35        if(bobPath[node] == -1 || bobPath[node] > time){
36            curr += amount[node];
37        }
38        if(bobPath[node] == time){
39            curr += amount[node] / 2;
40        }
41        if(adj.get(node).size() == 1 && node != 0) return curr;
42        int maxScore = Integer.MIN_VALUE;
43        for(int nbr : adj.get(node)){
44            if(nbr != parent){
45                maxScore = Math.max(maxScore, score(nbr, node, amount, time + 1, curr));
46            }
47        }
48        return maxScore;
49    }
50}