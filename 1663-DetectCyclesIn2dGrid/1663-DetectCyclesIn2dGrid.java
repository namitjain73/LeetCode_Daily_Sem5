// Last updated: 7/9/2026, 5:15:43 PM
class Solution {
    
    int[][] directions = {{0,1},{1,0},{0,-1},{-1,0}};
    
    public boolean containsCycle(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        
        boolean[][] visited = new boolean[m][n];
        
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                
                if(!visited[i][j]) {
                    if(dfs(grid, visited, i, j, -1, -1)) {
                        return true;
                    }
                }
            }
        }
        
        return false;
    }
    
    private boolean dfs(char[][] grid, boolean[][] visited, int r, int c, int pr, int pc) {
        
        visited[r][c] = true;
        
        for(int[] d : directions) {
            int nr = r + d[0];
            int nc = c + d[1];
            if(nr < 0 || nc < 0 || nr >= grid.length || nc >= grid[0].length) {
                continue;
            }
            if(grid[nr][nc] != grid[r][c]) {
                continue;
            }
            if(!visited[nr][nc]) {
                if(dfs(grid, visited, nr, nc, r, c)) {
                    return true;
                }
            } 
            else if(nr != pr || nc != pc) {
                return true;
            }
        }
        
        return false;
    }
}