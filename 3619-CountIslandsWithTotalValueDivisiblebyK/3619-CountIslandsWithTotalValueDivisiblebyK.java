// Last updated: 10/26/2026, 5:31:34 PM
1class Solution {
2    public int countIslands(int[][] grid, int k) {
3        int n  = grid.length;
4        int m =  grid[0].length;
5        int res = 0;
6
7        for(int i= 0 ; i < n ; i++){
8            for(int j = 0 ; j < m ; j++){
9                if(grid[i][j] > 0){
10                    long ans = solver(grid , i , j );
11                    if(ans % k== 0) res++;
12                }
13            }
14        }
15        return res;        
16    }
17    public long solver(int[][] grid , int i , int j){
18        if(i >= grid.length || j >= grid[0].length || i < 0 || j < 0 || grid[i][j] <= 0) return 0;
19
20        long n = grid[i][j];
21        grid[i][j] = 0;
22        long l = solver(grid , i+1 , j );
23        long r = solver(grid , i , j+1 );
24        long u = solver(grid , i-1 , j );
25        long d = solver(grid , i , j-1 );
26
27        //grid[i][j] = n;
28        return l+r+d+u+n;
29    }
30}