// Last updated: 7/9/2026, 5:23:30 PM
class Solution {
    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int island= 0;

        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(grid[i][j] == '1'){
                    dfs(grid,i,j);
                    island++;
                }
            }
        }
        return island;
    }

    public void dfs(char[][] grid , int i , int j){
        grid[i][j] = '0';
        int[] a = {1,-1,0,0};
        int[] b = {0,0,1,-1};
        for(int k = 0 ;  k< 4 ; k++){
            int nx = a[k] + i;
            int ny = b[k] + j;
            if(nx >= 0 && ny >= 0 && nx < grid.length && ny < grid[0].length && grid[nx][ny] == '1'){
                dfs(grid , nx , ny);
            }
        }
    }
}