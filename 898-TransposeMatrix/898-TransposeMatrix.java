// Last updated: 7/9/2026, 5:19:09 PM
class Solution {
    public int[][] transpose(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] ans = new int[n][m];
        for(int i = 0 ; i  < m ; i++){
            for(int j = 0 ; j < n ; j++){
                ans[j][i] = matrix[i][j];
            }
        }
        return ans;

        
    }
}