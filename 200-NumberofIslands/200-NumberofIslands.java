// Last updated: 12/30/2025, 12:14:26 PM
1class Solution {
2    public int numIslands(char[][] grid) {
3        
4
5
6        int r = grid.length;
7        int c = grid[0].length;
8        int ans= 0;
9        boolean[][] visited = new boolean[r][c];
10
11        for(int i = 0 ; i < r ; i++){
12            for(int j = 0 ; j < c ; j++){
13                if(grid[i][j] == '1' && !visited[i][j]){
14                    ans++;
15                    // dfs(grid , visited , i , j);
16                    bfs(grid , visited , i , j);
17                }
18            }
19        }
20        return ans;
21    }
22
23    public void bfs(char[][] grid , boolean[][] visited , int i , int j){
24        Queue<int[]> q = new LinkedList<>();
25        q.add(new int[]{i,j});
26        int[] a = {1,-1,0,0};
27        int[] b = {0,0,1,-1};
28
29        while(!q.isEmpty()){
30            int size = q.size();
31            int[] curr = q.poll();
32            for(int k = 0 ; k < 4 ; k++){
33                int newx = a[k] + curr[0];
34                int newy = b[k] + curr[1];
35                if(newx >= 0 && newy >= 0 && newx < grid.length && newy < grid[0].length && grid[newx][newy] == '1' && !visited[newx][newy]){
36                    q.add(new int[]{newx,newy});
37                    visited[newx][newy] = true;
38                }
39            }
40        }
41
42    }
43
44    public static void dfs(char[][] grid , boolean[][] visited , int i , int j){
45	    
46        
47        if(i< 0 || j < 0 || i >= grid.length || j >= grid[0].length || visited[i][j] || grid[i][j] == '0') return;
48
49        visited[i][j] = true;
50        int[] a = {1,-1,0,0};
51        int[] b = {0,0,1,-1};
52        for(int k = 0 ; k < 4 ; k++){
53            dfs(grid,visited , i+a[k] , j+b[k]);
54        }
55
56	}
57}