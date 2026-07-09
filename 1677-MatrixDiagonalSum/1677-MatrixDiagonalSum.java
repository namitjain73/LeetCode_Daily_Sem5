// Last updated: 7/9/2026, 5:15:33 PM
class Solution {
    public static int diagonalSum(int[][] mat) {
        int sum = 0;
        int i = 0;
        int j = 0;
        int n = mat.length;
        while(i < n && j < n){
            sum += mat[i][j];
            i++;
            j++;
        }
        i = 0;
        j = n-1;
        while(i < n && j >= 0){
            sum += mat[i][j];
            i++;
            j--;
        }

        int idx = (int)(n/2);
        if(n % 2 != 0){
            sum -= mat[idx][idx];
        }
        return sum;
	        
	    }
}