// Last updated: 7/9/2026, 5:06:45 PM
class Solution {
    public boolean areSimilar(int[][] mat, int k) {
        int n = mat.length;
        int m = mat[0].length;
        int[][] arr = new int[n][m];
        k = k % m;

        // if(k != 0){
            for(int i = 0 ; i < n ; i++){
                if(i % 2 == 0){
                    pos(mat[i] , k , arr[i]);
                }else{
                    neg(mat[i] , k , arr[i]);
                }
            }
        // }
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(mat[i][j] != arr[i][j]) return false;
             }
        }
        return true;
    }

    public void neg(int[] mat , int k , int[] arr){
        int n = mat.length;
        for(int i  = 0 ;i < n ; i++){
            arr[(i+k)%n] = mat[i];
        }
    }

    public void pos(int[] mat , int k , int[] arr){
        int n = mat.length;
        for(int i  = 0 ;i < n ; i++){
            arr[i] = mat[(i+k)%n];
        }
    }
}