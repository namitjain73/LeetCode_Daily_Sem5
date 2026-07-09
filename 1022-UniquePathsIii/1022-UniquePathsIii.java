// Last updated: 7/9/2026, 5:18:25 PM
class Solution {
    int ans;
    int[] a = {1,-1,0,0};
    int[] b = {0,0,1,-1};
    public int uniquePathsIII(int[][] grid) {
        ans = 0;
        int c = 0;
        int n = grid.length;
        int m = grid[0].length;
        for(int i = 0 ; i <n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(grid[i][j] == 0) c++;
            }
        }
        int[][] dp = new int[n][m];
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j <m ; j++){
                if(grid[i][j] == 1){
                    // System.out.println(i + " " + j);
                    solver(grid,c,0,i,j);
                }
            }
        }
        return ans;
    }
    public void solver(int[][] grid ,int c,  int count ,int i , int j){
        if(i < 0 || j < 0 || i >= grid.length || j>= grid[0].length || grid[i][j] == -1) return;
        if(grid[i][j] == 2){
            // System.out.println(count + " " + c);
            if(count-1 == c) ans++;
            return;
        }
        grid[i][j] = -1;
        for(int k = 0 ; k < 4 ; k++){
            int x = i + a[k];
            int y = j + b[k];
            solver(grid,c,count+1 , x,y);
            
        }
        grid[i][j] = 0;
    }
}