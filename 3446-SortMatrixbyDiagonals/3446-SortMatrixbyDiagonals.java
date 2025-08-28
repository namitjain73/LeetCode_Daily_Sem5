// Last updated: 8/29/2025, 12:47:36 AM
class Solution {
    public int[][] sortMatrix(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] arr = new int[n][m];

        for(int i = 0; i < n ; i++){
            List<Integer> ll = new ArrayList<>();
            for(int j = 0 ; i+j < n && j < m ; j++){
                ll.add(grid[i+j][j]);
            }
            Collections.sort(ll , Collections.reverseOrder());
            for(int j = 0 ; i+j < n && j < m ; j++){
                grid[i+j][j] = ll.get(j);
            }
            // System.out.println(ll);
        }
        
        int c = 1;
        int x = n-1;
        for(int i = 0; i < n && x > 0;x--){
            List<Integer> ll = new ArrayList<>();
            for(int j = c; i+j-c < n && j < m ; j++){
                ll.add(grid[i+j-c][j]);
            }
            Collections.sort(ll);
            for(int j = c ; i+j-c < n && j < m ; j++){
                grid[i+j-c][j] = ll.get(j-c);
            }
            c++;
            System.out.println(ll);
        }
        return grid;
    }
}