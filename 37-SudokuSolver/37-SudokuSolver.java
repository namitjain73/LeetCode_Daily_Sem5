// Last updated: 5/9/2026, 12:15:35 PM
1class Solution {
2    public void solveSudoku(char[][] board) {
3        solver(board , 0 , 0);
4        return;
5    }
6    public boolean solver(char[][] board , int row , int col){
7        if(col == 9){
8            col = 0;
9            row++;
10        }
11        if(row == 9){
12            return true;
13        }
14        if(board[row][col] != '.') return solver(board, row,col+1);
15        else{
16            for(int i = 1 ; i <= 9 ; i++){
17                if(isSafe(board , row  , col , i)){
18                    board[row][col] = (char)('0' + i);
19                    if(solver(board, row , col+1))  return true;
20                    board[row][col] = '.';
21                }
22            }
23        }
24        return false;
25    }
26    public boolean isSafe(char[][] board , int row , int col, int t){
27        int r = 0;
28        while(r < 9){
29            if(board[r][col] == (char)(t + '0')) return false;
30            r++;
31        }
32
33        int c = 0;
34        while(c < 9){
35            if(board[row][c] == (char)(t + '0')) return false;
36            c++;
37        }
38
39        r = row - row % 3;
40        c = col - col % 3;
41        for(int i  = r ; i < (r+3) ; i++){
42            for(int j = c ; j < (c+3);  j++){
43                if(board[i][j] == (char)(t+'0')) return false;
44            }
45        }
46        return true;
47    }
48}