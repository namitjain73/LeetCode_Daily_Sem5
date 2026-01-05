// Last updated: 1/5/2026, 6:37:10 PM
1class Solution {
2    public long maxMatrixSum(int[][] matrix) {
3        int min = Integer.MAX_VALUE;
4        long sum = 0L;
5        int count = 0;
6        for(int i = 0 ; i < matrix.length; i++){
7            for(int j = 0; j < matrix[0].length ; j++){
8                min = Math.min(min , Math.abs(matrix[i][j]));
9                sum +=Math.abs(matrix[i][j]);
10                if(matrix[i][j] < 0) count++;
11            }
12        }
13
14        if(count % 2 == 0) return sum;
15        return sum - 2*min;
16    }
17}