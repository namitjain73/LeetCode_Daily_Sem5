// Last updated: 10/16/2025, 2:13:38 AM
class Solution {
    int[] a = {1,-1,0,0};
    int[] b = {0,0,1,-1};
    public int getMaximumGold(int[][] grid) {
        int max = 0;
        for(int i = 0 ;  i < grid.length ; i++){
            for(int j = 0 ; j < grid[0].length ; j++){
                if(grid[i][j] != 0){
                    max = Math.max(max,solver(grid,i,j));
                }
            }
        }
        return max;
    }
    public int solver(int[][] arr,  int i , int j){
        if(i < 0 || j <  0 || i >= arr.length || j >= arr[0].length || arr[i][j] == 0) return Integer.MIN_VALUE;

        int ans = 0;
        int curr= arr[i][j];
        arr[i][j] = 0;
        for(int k = 0 ; k< 4 ; k++){
            int x = i + a[k];
            int y = j + b[k];
            ans = Math.max(ans,solver(arr, x , y));
        }
        arr[i][j] = curr;
        return ans+arr[i][j];
    }
}