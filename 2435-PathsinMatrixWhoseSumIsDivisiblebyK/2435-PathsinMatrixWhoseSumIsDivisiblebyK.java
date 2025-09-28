// Last updated: 9/29/2025, 12:49:26 AM
class Solution {
    private static int mod = 1_000_000_007;
    public int numberOfPaths(int[][] arr, int k) {
        int m = arr.length;
        int n = arr[0].length;
        int[][][] dp= new int[m][n][k];
        for(int i = 0; i < m; i++)
            for(int j = 0; j < n; j++)
                Arrays.fill(dp[i][j], -1);

        return solver(arr , m , n , 0 , 0 ,0,k, dp)%mod;

    }
    public int solver(int[][] arr , int m ,int n , int cr , int cc ,int sum,int k , int[][][] dp){
        if(cr == m || cc == n || arr[cr][cc] == -1) return 0;
        sum = (sum+arr[cr][cc])%k;
        if(cr == m-1 && cc == n-1) return sum==0?1:0;
        if(dp[cr][cc][sum] != -1) return dp[cr][cc][sum];
        return dp[cr][cc][sum] = (solver(arr,m,n,cr+1,cc,sum,k,dp)+solver(arr,m,n,cr,cc+1,sum,k,dp))%mod;
    }
}