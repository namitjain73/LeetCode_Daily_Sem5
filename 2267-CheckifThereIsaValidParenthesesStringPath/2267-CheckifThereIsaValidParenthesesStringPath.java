// Last updated: 9/29/2026, 2:00:00 PM
1class Solution {
2    public boolean hasValidPath(char[][] grid) {
3        int n = grid.length;
4        int m = grid[0].length;
5        int[][][] dp = new int[n][m][n+m+1];
6        for(int[][] dpp : dp) for(int[] d : dpp) Arrays.fill(d, -1);
7        int ans = solver(grid , 0 , 0, 0 , dp);
8        return ans == 1;
9    }
10    public int solver(char[][] arr , int oc, int i , int j , int[][][] dp){
11        if(i >= arr.length || j >= arr[0].length) return 0;
12        if(i == arr.length-1 && j == arr[0].length-1){
13            if(oc == 1 && arr[i][j] == ')') return 1;
14            return 0;
15        }
16        if(oc < 0) return 0;
17        if(dp[i][j][oc] != -1) return dp[i][j][oc];
18
19        int ans = 0;
20        if(arr[i][j] == '('){
21            ans = solver(arr , oc+1 , i+1 , j , dp);
22            if(ans == 1) return dp[i][j][oc] = 1;
23            ans = solver(arr , oc+1 , i , j+1 , dp);
24            if(ans == 1) return dp[i][j][oc] = 1;
25        }else{
26            ans = solver(arr , oc-1 , i+1 , j , dp);
27            if(ans == 1) return dp[i][j][oc] = 1;
28            ans = solver(arr , oc-1 , i , j+1 , dp);
29            if(ans == 1) return dp[i][j][oc] = 1;
30        }
31        return dp[i][j][oc] = 0;
32    }
33}