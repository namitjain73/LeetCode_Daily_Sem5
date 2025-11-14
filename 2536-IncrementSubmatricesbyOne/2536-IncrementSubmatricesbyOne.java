// Last updated: 11/15/2025, 1:14:54 AM
class Solution {
    public int[][] rangeAddQueries(int n, int[][] queries) {
        int[][] arr = new int[n][n];
        for(int[] i: queries){
            solver(arr , i[0] , i[1] , i[2] , i[3]);
        }
        return arr;
    }
    public void solver(int[][] arr, int x , int y , int n , int m){
        for(int i = x ; i <= n && i < arr.length; i++){
            for(int j = y ; j <= m && j < arr[0].length ; j++){
                arr[i][j]++;
            }
        }
    }
}