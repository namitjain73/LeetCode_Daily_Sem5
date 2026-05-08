// Last updated: 5/8/2026, 5:09:20 PM
1class Solution {
2    public List<List<String>> solveNQueens(int n) {
3        List<String> list = new ArrayList<>();
4        List<List<String>> ll = new ArrayList<>();
5        int[][] board = new int[n][n];
6        solver(board , n , list , ll , 0);
7        return ll;
8    }
9    public void solver(int[][] board , int n , List<String> list , List<List<String>> ll , int i){
10        if(n == 0){
11            System.out.println(list);
12            ll.add(new ArrayList<>(list));
13            return;
14        }
15
16        for(int col= 0 ; col < board.length  ;col++){
17            if(possible(board , i , col)){
18                board[i][col] = 1;
19                list.add(getRow(col,board.length));
20                solver(board , n-1 , list , ll , i+1);
21                list.remove(list.size()-1);
22                board[i][col] = 0;
23            }
24        }
25
26    }
27    	public static boolean possible(int[][] board , int row , int col){
28		int r = row;
29		while(r >= 0) {
30			if(board[r][col]== 1) {
31				return false;
32			}
33			r--;
34		}
35		r = row;
36		int c = col;
37		while(r >= 0 && c < board[0].length) {
38			if(board[r][c]==1) {
39				return false;
40			}
41			r--;
42			c++;
43		}
44		r = row;
45		c = col;
46		while(r >= 0 && c >= 0) {
47			if(board[r][c]==1) {
48				return false;
49			}
50			r--;
51			c--;
52		}
53		return true;	
54	}
55    public String getRow(int c, int n){
56        StringBuilder sb = new StringBuilder();
57        sb.append(".".repeat(n));
58        sb.setCharAt(c,'Q');
59        return sb.toString();
60    }
61}