// Last updated: 7/9/2026, 5:25:19 PM
class Solution {
    static int c = 0;
    public int totalNQueens(int n) {
        boolean[][] board = new boolean[n][n];
        c = 0; 
        solve(board , 0 , n);
        return c;
        
    }

    public void solve(boolean[][] board , int row , int noq){
        if(noq == 0){
            c++;
            return;
        }

        for(int i = 0 ; i < board[0].length ; i ++){
            if(isitsafe(board , row , i)){
                board[row][i] = true;
                solve(board , row+1 , noq-1);
                board[row][i] = false;
            }
        }
    }

    public boolean isitsafe(boolean[][] board , int row , int col){
        int r = row;
        int c = col;
        while(r >= 0){
            if(board[r][c]) return false;
            r--;
        }

        r = row;
        c = col;

        while(r >= 0 && c >= 0){
            if(board[r][c]) return false;
            r--;
            c--;
        }

        r = row;
        c = col;

        while(r >= 0 && c < board[0].length){
            if(board[r][c]) return false;
            r--;
            c++;
        }

        return true;
    }
}