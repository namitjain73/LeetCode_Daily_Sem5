// Last updated: 7/9/2026, 5:07:05 PM
class Solution {
    public int[][] constructProductMatrix(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int size = n * m;
        int mod = 12345;

        int[] arr = new int[size];
        int[] pre = new int[size];
        int[] suf = new int[size];

        int idx = 0;

        for(int i = 0 ; i < m ; i++){
            for(int j = 0 ; j < n ; j++){
                arr[idx++] = grid[i][j];
            }
        }

        suf[0] = 1;
        for(int i = 1 ; i < size ; i++){
            suf[i] = (int)(((long)suf[i-1] * arr[i-1]) % mod);
        }

        pre[size-1] = 1;
        for(int i = size-2 ; i >= 0 ; i--){
            pre[i] = (int)(((long)pre[i+1] * arr[i+1]) % mod);
        }

        idx = 0;
        for(int i = 0 ; i < m ; i++){
            for(int j = 0 ; j < n ; j++){
                grid[i][j] = (int)(((long)pre[idx] * suf[idx]) % mod);
                idx++;
            }
        }

        return grid;
    }
}