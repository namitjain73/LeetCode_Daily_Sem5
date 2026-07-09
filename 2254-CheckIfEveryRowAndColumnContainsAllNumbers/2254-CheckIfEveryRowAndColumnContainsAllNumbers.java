// Last updated: 7/9/2026, 5:11:51 PM
class Solution {
    public boolean checkValid(int[][] matrix) {
        int n = matrix.length;

        for(int i = 0 ; i < n ; i++){
            int[] arr = new int[n+1];
            for(int j = 0 ; j < n ; j++){
                if(arr[matrix[i][j]] == 1) return false;
                arr[matrix[i][j]]++;
            }
            
        }

        for(int i = 0 ; i < n ; i++){
            int[] arr = new int[n+1];
            for(int j = 0 ;j < n ; j++){
                if(arr[matrix[j][i]] == 1) return false;
                arr[matrix[j][i]]++;
            }
        }
        return true;
    }
}