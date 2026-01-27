// Last updated: 1/27/2026, 11:06:43 PM
1class Solution {
2    public int closestMeetingNode(int[] edges, int node1, int node2) {
3        int n = edges.length;
4        int[] dist1 = new int[n];
5        int[] dist2 = new int[n];
6        Arrays.fill(dist1,-1);
7        Arrays.fill(dist2,-1);
8        solver(node1 , 0 , edges , dist1);
9        solver(node2 , 0 , edges , dist2);
10        int min = Integer.MAX_VALUE;
11        int res = -1;
12
13        for(int i = 0 ;i < n ; i++){
14            if(dist1[i] < 0 || dist2[i] < 0 ) continue;
15            int max = Math.max(dist1[i] , dist2[i]);
16            if(max < min){
17                min = max;
18                res = i;
19            }
20        }
21        return res;
22    }
23    public void solver(int curr , int d , int[] edges , int[] dist){
24        while(curr != -1 && dist[curr] == -1){
25            dist[curr] = d++;
26            curr = edges[curr];
27        }
28    }
29}