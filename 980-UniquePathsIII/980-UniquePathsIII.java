// Last updated: 1/5/2026, 10:00:12 PM
1class Solution {
2    int ans;
3    int[] a = {1,-1,0,0};
4    int[] b = {0,0,1,-1};
5    public int uniquePathsIII(int[][] grid) {
6        ans = 0;
7        int c = 0;
8        int n = grid.length;
9        int m = grid[0].length;
10        for(int i = 0 ; i <n ; i++){
11            for(int j = 0 ; j < m ; j++){
12                if(grid[i][j] == 0) c++;
13            }
14        }
15        int[][] dp = new int[n][m];
16        for(int i = 0 ; i < n ; i++){
17            for(int j = 0 ; j <m ; j++){
18                if(grid[i][j] == 1){
19                    // System.out.println(i + " " + j);
20                    solver(grid,c,0,i,j);
21                }
22            }
23        }
24        return ans;
25    }
26    public void solver(int[][] grid ,int c,  int count ,int i , int j){
27        if(i < 0 || j < 0 || i >= grid.length || j>= grid[0].length || grid[i][j] == -1) return;
28        if(grid[i][j] == 2){
29            // System.out.println(count + " " + c);
30            if(count-1 == c) ans++;
31            return;
32        }
33        grid[i][j] = -1;
34        for(int k = 0 ; k < 4 ; k++){
35            int x = i + a[k];
36            int y = j + b[k];
37            solver(grid,c,count+1 , x,y);
38            
39        }
40        grid[i][j] = 0;
41    }
42}