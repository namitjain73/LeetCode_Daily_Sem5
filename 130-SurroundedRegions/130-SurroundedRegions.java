// Last updated: 3/16/2026, 2:15:35 PM
1class Solution {
2    public void solve(char[][] board) {
3        int n = board.length;
4        int m = board[0].length;
5
6        // Step 1: mark boundary connected O's
7        for(int i = 0; i < n; i++){
8            dfs(board, i, 0);
9            dfs(board, i, m - 1);
10        }
11
12        for(int j = 0; j < m; j++){
13            dfs(board, 0, j);
14            dfs(board, n - 1, j);
15        }
16
17        // Step 2: convert remaining O -> X
18        for(int i = 0; i < n; i++){
19            for(int j = 0; j < m; j++){
20                if(board[i][j] == 'O') board[i][j] = 'X';
21                if(board[i][j] == '#') board[i][j] = 'O';
22            }
23        }
24    }
25
26    public void dfs(char[][] board, int i, int j){
27        if(i < 0 || j < 0 || i >= board.length || j >= board[0].length || board[i][j] != 'O')
28            return;
29
30        board[i][j] = '#';
31
32        dfs(board, i + 1, j);
33        dfs(board, i - 1, j);
34        dfs(board, i, j + 1);
35        dfs(board, i, j - 1);
36    }
37}