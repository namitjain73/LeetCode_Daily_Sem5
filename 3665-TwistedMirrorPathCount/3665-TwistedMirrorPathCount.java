// Last updated: 10/31/2026, 8:52:13 PM
1class Solution {
2    int mod = 1_000_000_007;
3    public int uniquePaths(int[][] grid) {
4        int n = grid.length;
5        int m = grid[0].length;
6        int[][][] dp = new int[n][m][3];
7        for(int[][] a : dp) for(int[] b : a) Arrays.fill(b , -1);
8        int ans = solver(grid, 0 , 0  , 0 , dp);
9        return ans;
10    }
11    public int solver(int[][] arr , int i , int j , int ch , int[][][] dp){
12        // System.out.println(i + " "  +j);
13        if(i >= arr.length || j >= arr[0].length) return 0;
14        if(i == arr.length-1 && j == arr[0].length-1) return 1;
15        if(dp[i][j][ch] != -1) return dp[i][j][ch];
16
17        int ans = 0;
18        if(arr[i][j] == 0){
19            ans += solver(arr , i+1 , j , 1 , dp);
20            ans  += solver(arr , i , j+1 , 2 , dp);
21        }
22        else if(arr[i][j] == 1 && ch == 1) ans += solver(arr , i , j+1 , 2 , dp);
23        else if(arr[i][j] == 1 && ch == 2) ans += solver(arr , i+1 , j , 1 , dp);
24        return dp[i][j][ch] = (ans%mod);
25    }
26}