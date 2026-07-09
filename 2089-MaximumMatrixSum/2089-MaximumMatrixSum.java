// Last updated: 7/9/2026, 5:13:30 PM
class Solution {
    public long maxMatrixSum(int[][] matrix) {
        int min = Integer.MAX_VALUE;
        long sum = 0L;
        int count = 0;
        for(int i = 0 ; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length ; j++){
                min = Math.min(min , Math.abs(matrix[i][j]));
                sum +=Math.abs(matrix[i][j]);
                if(matrix[i][j] < 0) count++;
            }
        }

        if(count % 2 == 0) return sum;
        return sum - 2*min;
    }
}