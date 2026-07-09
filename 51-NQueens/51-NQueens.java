// Last updated: 7/9/2026, 5:25:21 PM
class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<String> list = new ArrayList<>();
        List<List<String>> ll = new ArrayList<>();
        int[][] board = new int[n][n];
        solver(board , n , list , ll , 0);
        return ll;
    }
    public void solver(int[][] board , int n , List<String> list , List<List<String>> ll , int i){
        if(n == 0){
            System.out.println(list);
            ll.add(new ArrayList<>(list));
            return;
        }

        for(int col= 0 ; col < board.length  ;col++){
            if(possible(board , i , col)){
                board[i][col] = 1;
                list.add(getRow(col,board.length));
                solver(board , n-1 , list , ll , i+1);
                list.remove(list.size()-1);
                board[i][col] = 0;
            }
        }

    }
    	public static boolean possible(int[][] board , int row , int col){
		int r = row;
		while(r >= 0) {
			if(board[r][col]== 1) {
				return false;
			}
			r--;
		}
		r = row;
		int c = col;
		while(r >= 0 && c < board[0].length) {
			if(board[r][c]==1) {
				return false;
			}
			r--;
			c++;
		}
		r = row;
		c = col;
		while(r >= 0 && c >= 0) {
			if(board[r][c]==1) {
				return false;
			}
			r--;
			c--;
		}
		return true;	
	}
    public String getRow(int c, int n){
        StringBuilder sb = new StringBuilder();
        sb.append(".".repeat(n));
        sb.setCharAt(c,'Q');
        return sb.toString();
    }
}