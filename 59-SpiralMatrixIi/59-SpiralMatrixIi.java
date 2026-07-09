// Last updated: 7/9/2026, 5:25:11 PM
class Solution {
    public int[][] generateMatrix(int n) {
        int c = 1;
        int[][] arr = new int[n][n];
        int minc = 0;
        int minr = 0;
        int maxc = n-1;
        int maxr = n-1;

        while(c <= n*n){
            for(int i = minc ; i <= maxc && c <= n*n ; i++){
                arr[minr][i] = c;
                c++;
            }
            minr++;
            for(int i = minr ; i <= maxr && c <= n*n ; i++){
                arr[i][maxc] = c;
                c++;
            }
            maxc--;
            for(int i = maxc ; i >= minc && c <= n*n ; i--){
                arr[maxr][i] = c;
                c++;
            }
            maxr--;
            for(int i = maxr ; i >= minr && c <= n*n ; i--){
                arr[i][minc] = c;
                c++;
            }
            minc++;
        }
        return arr;
        
    }
}