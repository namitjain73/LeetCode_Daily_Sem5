// Last updated: 7/9/2026, 5:17:11 PM
class Solution {
    int n;
    int m;
    public int solve(int i , int j , int[][] matrix , int[][] dp){
        if(i >= n || j >= m) return 0;
        if(matrix[i][j] == 0) return 0;
        if(dp[i][j] != -1) return dp[i][j];

        int left = solve(i , j + 1 , matrix, dp);
        int dig = solve(i + 1, j + 1 , matrix, dp);
        int down = solve(i + 1, j , matrix, dp);

        return dp[i][j] = 1 + Math.min(left,Math.min(dig,down));
    }
    public int countSquares(int[][] matrix) {
        n = matrix.length;
        m = matrix[0].length;
        int[][] dp = new int[n+1][m+1];
        for(int i = 0 ; i <= n ; i++){
            Arrays.fill(dp[i],-1);
        }

        int result = 0;
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(matrix[i][j] == 1){
                    result += solve(i,j,matrix,dp);
                }
            }
        }
        return result;
    }
}