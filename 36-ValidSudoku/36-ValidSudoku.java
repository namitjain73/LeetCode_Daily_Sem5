// Last updated: 8/30/2025, 10:51:50 AM
class Solution {
    public boolean isValidSudoku(char[][] board) {
        return helper(board,0,0);
    }
    private boolean helper(char[][] board , int row , int col){
        for(int i = 0 ; i < 9 ; i++){
            for(int j = 0 ; j < 9 ; j++){
                char ch = board[i][j];
                if(ch != '.'){
                    board[i][j] = '.';
                    if(!isValid(board,i,j,ch)){
                        return false;
                    }
                    board[i][j] = ch;
                }
            }
        }
        return true;
    }

    private boolean isValid(char[][] grid , int row, int col , char ch){
        // row check
        for(int i = 0 ; i < 9 ; i++) {
            if(grid[row][i] == ch) return false;
        }

        // col check
        for(int i = 0 ; i < 9 ; i++) {
            if(grid[i][col] == ch) return false;
        }

        // 3x3 subgrid
        int r = row - row % 3;
        int c = col - col % 3;
        for(int i = r ; i < r + 3 ; i++) {
            for(int j = c ; j < c + 3 ; j++) {
                if(grid[i][j] == ch) return false;
            }
        }
        return true;
    }
}