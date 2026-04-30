// Last updated: 4/30/2026, 11:24:50 AM
1class Solution {
2    public int maxPathScore(int[][] grid, int k) {
3        int[][][] dp = new int[grid.length][grid[0].length][k+1];
4        for(int[][] arr : dp){
5            for(int[] arr1 :arr) Arrays.fill(arr1 , -2);
6        }
7        int ans = solver(grid,k,0,0,dp);
8        return ans < 0 ? -1 : ans;
9    }
10    public int solver(int[][] grid , int k , int i , int j ,int[][][] dp){
11        int m = grid[0].length;
12        int n = grid.length;
13        if( i >= n || j >= m) return -1;
14        int cost = grid[i][j] == 0 ? 0 : 1;
15        if((k-cost) < 0) return -1;
16        
17        if(i == n-1 && j == m-1){
18            return grid[i][j];
19        }
20
21        if(dp[i][j][k] != -2) return dp[i][j][k];
22
23
24        int right = solver(grid , k-cost , i , j+1,dp);
25        int down  = solver(grid , k-cost , i+1 , j,dp);
26        int max = Math.max(right,down);
27        if(max == -1) dp[i][j][k] = -1;
28        else dp[i][j][k] = max + grid[i][j];
29        return dp[i][j][k];
30    }
31}