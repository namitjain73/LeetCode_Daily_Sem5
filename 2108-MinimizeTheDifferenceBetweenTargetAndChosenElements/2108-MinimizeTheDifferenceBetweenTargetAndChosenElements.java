// Last updated: 7/9/2026, 5:13:11 PM
class Solution {
    public int minimizeTheDifference(int[][] mat, int t) {
        Integer[][] dp = new Integer[mat.length][5001];
        return solver(mat , t , 0, 0  ,dp);
    }
    public int solver(int[][] mat , int t ,int val , int i , Integer[][] dp){
        if(i == mat.length) {
            return Math.abs(t - val);
        }
        if(dp[i][val] != null) return dp[i][val];

        int res = Integer.MAX_VALUE;
        for(int j = 0 ; j < mat[0].length ; j++){
            res = Math.min(res , solver(mat , t , val + mat[i][j] , i+1,dp));
        }
        return dp[i][val] = res;
    }
}