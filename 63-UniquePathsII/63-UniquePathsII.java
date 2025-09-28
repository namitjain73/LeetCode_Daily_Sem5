// Last updated: 9/28/2025, 11:58:33 PM
class Solution {
    public int uniquePathsWithObstacles(int[][] arr) {
        int m = arr.length;
        int n = arr[0].length;
        int[][] dp= new int[m][n];
        for(int[] d : dp){
            Arrays.fill(d,-1);
        }
        return solver(arr , m , n , 0 , 0 , dp);

    }
    public int solver(int[][] arr , int m ,int n , int cr , int cc , int[][] dp){
        if(cr == m || cc == n || arr[cr][cc] == 1) return 0;
        if(cr == m-1 && cc == n-1) return 1;
        if(dp[cr][cc] != -1) return dp[cr][cc];
        int ans = 0;
        arr[cr][cc] = 1;
        ans += solver(arr,m,n,cr+1,cc,dp);
        ans += solver(arr,m,n,cr,cc+1,dp);
        arr[cr][cc] = 0;
        return dp[cr][cc] = ans;
    }
}