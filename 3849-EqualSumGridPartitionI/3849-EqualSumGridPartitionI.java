// Last updated: 7/9/2026, 5:00:56 PM
class Solution {
    public boolean canPartitionGrid(int[][] grid) {
        long sum = 0;
        int n = grid.length;
        int m = grid[0].length;
        for(int i = 0 ; i <n  ; i++){
            for(int j = 0 ; j < m ;  j++){
                sum += grid[i][j];
            }
        }
        if(sum % 2 == 1) return false;

        sum = sum / 2;
        long sum1 = 0;
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                sum1 += grid[i][j];
            }
            if(sum == sum1) return true;
        }

        sum1 = 0;
        for(int i = 0 ; i < m ; i++){
            for(int j = 0 ; j < n ; j++){
                sum1 += grid[j][i];
            }
            if(sum == sum1) return true;
        }


        return false;
    }
}