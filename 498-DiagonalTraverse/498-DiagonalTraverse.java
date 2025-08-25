// Last updated: 8/26/2025, 1:54:38 AM
class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        int[] arr = new int[n*m];
        boolean up = true;
        int row = 0;
        int col = 0;
        int i = 0;
        while(row < n && col < m){
            if(up){
                while(row > 0 && col < m-1){
                    arr[i] = mat[row][col];
                    row--;
                    col++;
                    i++;
                }
                arr[i++] = mat[row][col];

                if(col == m-1) row++;
                else col++;
            }else{
                while(col > 0 && row < n-1){
                    arr[i] = mat[row][col];
                    row++;
                    col--;
                    i++;
                }
                arr[i++] = mat[row][col];

                if(row == n-1) col++;
                else row++;
            }

            up = !up;
        }
        return arr;
    }
}