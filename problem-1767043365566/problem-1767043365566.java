// Last updated: 12/30/2025, 2:52:45 AM
1class Solution {
2    public int findCircleNum(int[][] grid) {
3        int ans = 0;
4        int n = grid.length;
5        boolean[] visited = new boolean[n];
6
7        for(int i = 0 ; i < n ; i++){
8            if(!visited[i]){
9                dfs(grid,visited,i);
10                ans++;
11            }
12        }
13        return ans;
14    }
15    public void dfs(int[][] grid , boolean[] visited , int node){
16        visited[node] = true;
17
18        for(int i = 0 ; i < grid.length ; i++){
19            if(!visited[i] && grid[node][i] == 1){
20                dfs(grid,visited,i);
21            }
22        }
23    }
24}