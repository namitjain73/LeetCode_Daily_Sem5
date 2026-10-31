// Last updated: 10/31/2026, 8:42:56 PM
1class Solution {
2    int mod = 1_000_000_007;
3    int[][][] dp;
4    public int uniquePaths(int[][] grid) {
5        dp = new int[grid.length][grid[0].length][2];
6        for (int i = 0; i < grid.length; i++) {
7    for (int j = 0; j < grid[0].length; j++) {
8        Arrays.fill(dp[i][j], -1);
9    }
10}
11        int c = path(grid , grid.length-1,grid[0].length-1,0,0,0);
12        return c;
13    }
14    public int path(int[][] board , int m , int n , int row , int col,int down){
15
16        if(row > m || col > n) return 0;
17        if(row == m && col == n){
18            return 1;
19        }
20
21        if(dp[row][col][down] != -1) return dp[row][col][down];
22        long c=0;
23
24        
25        if(board[row][col] == 1){
26            if(down == 1){ // go right
27                c += path(board,m,n,row,col+1,0);
28            }else{//go down
29                c += path(board,m,n,row+1,col,1);
30            }
31        }else{
32            //down
33            c += path(board,m,n,row+1,col,1);
34            //right
35            c += path(board,m,n,row,col+1,0);
36            
37        }
38        return dp[row][col][down] = (int)c%mod;
39    }
40}