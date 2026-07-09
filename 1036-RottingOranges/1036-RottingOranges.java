// Last updated: 7/9/2026, 5:18:23 PM
class Solution {
    public int orangesRotting(int[][] grid) {
        int minutes = 0;
        int total = 0;
        int n = grid.length;
        int m = grid[0].length;
        Queue<int[]> q= new LinkedList<>();
        int[] a = {1,-1,0,0};
        int[] b = {0,0,1,-1};
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ;  j < m ; j++){
                if(grid[i][j] == 1) total++;
                else if(grid[i][j] == 2) q.add(new int[]{i,j});
            }
        }


        while(!q.isEmpty()){
            int size = q.size();
            boolean flag = false;
            while(size-- > 0){
                int[] arr = q.poll();
                for(int i = 0  ; i < 4 ; i++){
                    int nx = arr[0]+a[i];
                    int ny = arr[1]+b[i];
                    if(nx >= 0 && ny >= 0 && nx < n && ny < m && grid[nx][ny] == 1){
                        total--;
                        flag = true;
                        grid[nx][ny] = 2;
                        q.add(new int[]{nx,ny});
                        System.out.println(nx + " " + ny + " " + minutes);
                    }
                }
            }
            
            if(flag) minutes++;
        }
        return total == 0 ? minutes : -1;
    }
}