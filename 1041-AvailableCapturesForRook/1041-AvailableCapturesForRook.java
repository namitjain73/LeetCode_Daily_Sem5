// Last updated: 7/9/2026, 5:18:20 PM
class Solution {
    public int numRookCaptures(char[][] board) {
        int row = 0;
        int col = 0;
        for(int i = 0 ; i < board.length ; i++){
            for(int j = 0 ; j < board[0].length ; j++){
                if(board[i][j] == 'R'){
                    row = i;
                    col = j;
                    break;
                }
            }
        }
        int p = 0;

        // up
        int r = row;
        while(r >= 0){
            if(board[r][col] == 'p'){
                p++;
                break;
            }
            if(board[r][col] == 'B'){
                break;
            }
            r--;
        }



        // down
        r = row;
        while(r < 8){
            if(board[r][col] == 'p'){
                p++;
                break;
            }
            if(board[r][col] == 'B'){
                break;
            }
            r++;
        }


        // left
        int c = col;
        while(c >= 0){
            if(board[row][c] == 'p'){
                p++;
                break;
            }
            if(board[row][c] == 'B'){
                break;
            }
            c--;
        }

        

        // right
        c = col;
        while(c < 8){
            if(board[row][c] == 'p'){
                p++;
                break;
            }
            if(board[row][c] == 'B'){
                break;
            }
            c++;
        }
        return p;
        
    }
    
}