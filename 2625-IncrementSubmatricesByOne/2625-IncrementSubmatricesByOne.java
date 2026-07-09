// Last updated: 7/9/2026, 5:08:45 PM
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