// Last updated: 8/31/2025, 10:57:51 AM
class Solution {
    public void solveSudoku(char[][] board) {
        solver(board,0,0);
    }
    public boolean solver(char[][] board , int row , int col){
        if(col == 9){
            col = 0;
            row++;
        }
        if(row == 9){
            return true;
        }
        if(board[row][col] != '.'){
            return solver(board,row,col+1);
        }else{
            for(int i =1 ; i <= 9 ; i++){
                if(ispossible(board , row , col , i)){
                    board[row][col] = (char)(i + '0');
                    if(solver(board,row,col+1)){
                        return true;
                    }
                    board[row][col] = '.';
                }
            }
        }
        return false;
    }

    public boolean ispossible(char[][] board , int row, int col , int n){
        int r = row;
        int c = col;
        int x = (char)(n + '0');
        for(int i =0 ; i < 9 ; i++){
            if(board[i][c] == x) return false;
        }
        for(int i = 0 ; i < 9 ; i++){
            if(board[r][i] == x) return false;
        }

        r = row - row % 3;
        c = col - col % 3;
        for(int i = r ; i < r + 3 ; i++){
            for(int j = c ; j < c + 3 ; j++){
                if(board[i][j] == x) return false;
            }
        }
        return true;
    }
}