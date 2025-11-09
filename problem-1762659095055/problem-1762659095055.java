// Last updated: 11/9/2025, 9:01:35 AM
class Solution {
    public int maxPathScore(int[][] grid, int k) {
        int[][][] dp = new int[grid.length][grid[0].length][k+1];
        for(int[][] arr : dp){
            for(int[] arr1 :arr) Arrays.fill(arr1 , -2);
        }
        int ans = solver(grid,k,0,0,dp);
        return ans < 0 ? -1 : ans;
    }
    public int solver(int[][] grid , int k , int i , int j ,int[][][] dp){
        int m = grid[0].length;
        int n = grid.length;
        if( i >= n || j >= m) return -1;
        int cost = grid[i][j] == 0 ? 0 : 1;
        if((k-cost) < 0) return -1;
        
        if(i == n-1 && j == m-1){
            return grid[i][j];
        }

        if(dp[i][j][k] != -2) return dp[i][j][k];


        int right = solver(grid , k-cost , i , j+1,dp);
        int down  = solver(grid , k-cost , i+1 , j,dp);
        int max = Math.max(right,down);
        if(max == -1) dp[i][j][k] = -1;
        else dp[i][j][k] = max + grid[i][j];
        return dp[i][j][k];
    }
}