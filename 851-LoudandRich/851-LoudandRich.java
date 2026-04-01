// Last updated: 4/1/2026, 11:55:36 AM
1class Solution {
2    int res;
3    public int[] loudAndRich(int[][] richer, int[] quiet) {
4        int n = quiet.length;
5        int[] ans = new int[n];
6        Map<Integer,ArrayList<Integer>> map= new HashMap<>();
7        for(int i = 0 ; i < n ; i++){
8            map.put(i , new ArrayList<>());
9        }
10
11        for(int i = 0 ; i < richer.length ; i++){
12            int u = richer[i][0];
13            int v = richer[i][1];
14            map.get(v).add(u);
15        }
16        Arrays.fill(ans , -1);
17
18        for(int i= 0 ; i < n ; i++){
19            solver(map , quiet , i ,ans);
20            // if(x != -1) ans[i] = x;
21            // else ans[i] = i;
22        }
23        return ans;
24    }
25    public int solver(Map<Integer,ArrayList<Integer>> map ,int[] arr , int node , int[] ans){
26        
27        if(ans[node] != -1) return ans[node];
28
29        int best = node;
30        for(int nbrs : map.get(node)){
31            int c = solver(map , arr , nbrs,  ans);
32
33            if(arr[c] < arr[best]){
34                best = c;
35            }
36        }
37        return ans[node] = best;
38    }
39}