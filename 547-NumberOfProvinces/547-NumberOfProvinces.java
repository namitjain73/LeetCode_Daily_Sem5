// Last updated: 7/9/2026, 5:20:55 PM
class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        int ans = 0;
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ; j++){
                if(isConnected[i][j] == 1) {
                    ans++;
                    dfs(isConnected , i , j);
                }
            }
        }
        for(int i = 0 ; i < n ; i++){
            if(isConnected[i][i] == 1){
                ans++;
            }
        }
        return ans;
    }
    public void dfs(int[][] arr , int i , int j){
        arr[i][j] = 0;
        arr[j][i] = 0;
        arr[i][i] = 0;
        arr[j][j] = 0;
        int n = arr.length;
        for(int k = 0 ; k < n ; k++){
            if(i != k && arr[j][k] == 1) dfs(arr , j , k);
        }
    }
}