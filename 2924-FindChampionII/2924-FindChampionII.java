// Last updated: 1/3/2026, 3:18:54 PM
1class Solution {
2    public int findChampion(int n, int[][] edges) {
3        int[] ans = new int[n];
4        for(int i = 0 ; i < edges.length ; i++){
5            ans[edges[i][1]]++;
6        }
7
8        boolean flag = true;
9        int x = 0;
10        for(int i = 0 ; i < n ; i++){
11            if(ans[i] == 0 && flag) {
12                flag = false;
13                x = i;
14            }
15            else if(ans[i] == 0) return -1; 
16        }
17        return x;
18
19
20    }
21}