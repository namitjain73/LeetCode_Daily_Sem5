// Last updated: 7/9/2026, 4:59:59 PM
class Solution {
    int mod = 1_000_000_007;
    int[][][] dp;
    public int uniquePaths(int[][] grid) {
        dp = new int[grid.length][grid[0].length][2];
        for (int i = 0; i < grid.length; i++) {
    for (int j = 0; j < grid[0].length; j++) {
        Arrays.fill(dp[i][j], -1);
    }
}
        int c = path(grid , grid.length-1,grid[0].length-1,0,0,0);
        return c;
    }
    public int path(int[][] board , int m , int n , int row , int col,int down){

        if(row > m || col > n) return 0;
        if(row == m && col == n){
            return 1;
        }

        if(dp[row][col][down] != -1) return dp[row][col][down];
        long c=0;

        
        if(board[row][col] == 1){
            if(down == 1){ // go right
                c += path(board,m,n,row,col+1,0);
            }else{//go down
                c += path(board,m,n,row+1,col,1);
            }
        }else{
            //down
            c += path(board,m,n,row+1,col,1);
            //right
            c += path(board,m,n,row,col+1,0);
            
        }
        return dp[row][col][down] = (int)c%mod;
    }
}