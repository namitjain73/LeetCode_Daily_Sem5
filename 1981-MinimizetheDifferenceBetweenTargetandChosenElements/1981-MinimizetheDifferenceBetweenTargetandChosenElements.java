// Last updated: 2/3/2026, 11:49:32 PM
1class Solution {
2    public int minimizeTheDifference(int[][] mat, int t) {
3        Integer[][] dp = new Integer[mat.length][5001];
4        return solver(mat , t , 0, 0  ,dp);
5    }
6    public int solver(int[][] mat , int t ,int val , int i , Integer[][] dp){
7        if(i == mat.length) {
8            return Math.abs(t - val);
9        }
10        if(dp[i][val] != null) return dp[i][val];
11
12        int res = Integer.MAX_VALUE;
13        for(int j = 0 ; j < mat[0].length ; j++){
14            res = Math.min(res , solver(mat , t , val + mat[i][j] , i+1,dp));
15        }
16        return dp[i][val] = res;
17    }
18}