// Last updated: 7/9/2026, 5:06:54 PM
class Solution {
    public int findChampion(int[][] grid) {
        for(int i = 0 ; i < grid.length ; i++){
            int count = 0;
            for(int j = 0  ; j < grid[0].length ; j++){
                if(grid[i][j] == 1){
                    count ++;
                    if(count == grid.length-1){
                    return i;
                }
                }
                
            }
        }
        return -1;
        
    }
}