// Last updated: 7/9/2026, 5:25:25 PM
class Solution {
    public void rotate(int[][] matrix) {
        img_rotate(matrix);
    }


    public static void img_rotate(int[][] arr){
        int n = arr.length;
        int m = arr[0].length;
        for(int i = 0 ; i < n ; i++){
            for(int j = i+1 ; j < m ; j++){
                int temp = arr[i][j];
                arr[i][j] = arr[j][i];
                arr[j][i] = temp;
            }
        }


        for(int i = 0 ; i < m ; i++){
            int lo = 0;
            int hi = m-1; 
            while(lo <= hi){
                int temp = arr[i][hi];
                arr[i][hi] = arr[i][lo];
                arr[i][lo] = temp;
                lo++;
                hi--;
            

            }
        }

    }
}