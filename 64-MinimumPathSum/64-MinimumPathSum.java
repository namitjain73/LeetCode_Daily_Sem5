// Last updated: 5/19/2026, 6:11:56 PM
1class Solution {
2    public int minPathSum(int[][] grid) {
3        int[][] dp= new int[grid.length][grid[0].length];
4        for(int[] d : dp) Arrays.fill(d , -1);
5        return solver(grid , 0 , 0 , dp);
6    }
7    public int solver(int[][] arr , int i , int j , int[][] dp){
8        if(i >= arr.length || j >= arr[0].length) return Integer.MAX_VALUE;
9        if(i == arr.length-1 && j == arr[0].length-1) return arr[i][j];
10        if(dp[i][j] != -1) return dp[i][j];
11
12        int left = solver(arr , i+1 , j , dp);
13        int right = solver(arr, i , j+1 , dp);
14        dp[i][j] = Math.min(left,right) + arr[i][j];
15        return dp[i][j];
16    }
17}