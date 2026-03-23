// Last updated: 3/24/2026, 1:49:28 AM
1class Solution {
2    public int minPathSum(int[][] grid) {
3        int[][] dp = new int[grid.length][grid[0].length];
4        for(int[] i : dp) Arrays.fill(i,-1);
5        return rec(grid , 0 , 0 , dp);
6        
7    }
8
9    public int rec(int[][] grid , int row , int col , int[][] dp){
10        if(row > grid.length-1 || col > grid[0].length-1){
11            return Integer.MAX_VALUE;
12        }
13        if(row == grid.length-1 && col == grid[0].length-1){
14            return grid[row][col];
15        }
16        if(dp[row][col] != -1) return dp[row][col];
17
18        int right = rec(grid , row + 1 , col , dp);
19        int down =  rec(grid , row , col + 1 , dp);
20        dp[row][col] = Math.min(right , down) + grid[row][col];
21        return dp[row][col];
22    }
23}