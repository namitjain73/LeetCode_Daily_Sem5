// Last updated: 7/9/2026, 5:24:51 PM
class Solution {
    public boolean exist(char[][] board, String word) {

        int n = board.length;
        int m = board[0].length;
        for(int i = 0;  i< n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(board[i][j] == word.charAt(0)) {
                    if(solve(board,word,i,j,n,m,0)) return true;
                }
            }
        }
        return false;
        
    }

    public boolean solve(char[][] board, String word,int r ,int c ,int n , int m, int idx) {

        if(idx == word.length()) return true;
        if(r < 0 || c < 0 || r >= n || c >= m || board[r][c] != word.charAt(idx)) return false;


        char ch = board[r][c];
        board[r][c] = '#';
        boolean up = solve(board,word,r - 1 ,c,n,m,idx + 1);
        boolean down = solve(board,word,r + 1,c,n,m,idx + 1);
        boolean left = solve(board,word,r,c - 1,n,m,idx + 1);
        boolean right = solve(board,word,r,c + 1,n,m,idx + 1);

        board[r][c] = ch;

        return up || down || left || right;
    }
}