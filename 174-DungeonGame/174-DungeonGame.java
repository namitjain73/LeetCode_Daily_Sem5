// Last updated: 1/5/2026, 3:05:26 PM
1class Solution {
2    public int calculateMinimumHP(int[][] dungeon) {
3        int n = dungeon.length;
4        int m = dungeon[0].length;
5        int[][] dp = new int[n][m];
6        for(int[] d : dp) Arrays.fill(d , -1);
7        return solver(dungeon , m , n , 0 , 0 , dp);
8    }
9    public int solver(int[][] grid, int m , int n , int i , int j , int[][] dp){
10        if(i >= n || j >= m) return Integer.MAX_VALUE;
11
12        if(i == n-1 && j == m-1){
13            return Math.max(1 , 1 - grid[i][j]);
14        }
15
16        if(dp[i][j] != -1) return dp[i][j];
17
18        int down = solver(grid , m , n , i+1 , j , dp);
19        int right = solver(grid , m , n , i , j+1 , dp);
20        return dp[i][j] = Math.max(1,Math.min(down , right) - grid[i][j]);
21    }
22}