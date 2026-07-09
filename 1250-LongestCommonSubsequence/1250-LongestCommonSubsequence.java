// Last updated: 7/9/2026, 5:17:40 PM
class Solution {
    public int longestCommonSubsequence(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        int[][] dp = new int[n][m];
        for(int[] d : dp) Arrays.fill(d , -1);
        return solver(s1 , s2 , 0 , 0 , dp);
    }
    public int solver(String s1 , String s2 , int i , int j , int[][] dp){
        if(i >= s1.length() || j >= s2.length()) return 0;
        if(dp[i][j] != -1) return dp[i][j];

        int x = 0;
        if(s1.charAt(i) == s2.charAt(j)){
            return dp[i][j] = solver(s1 , s2 , i+1 , j+1 , dp) + 1;
        }else{
            x = solver(s1, s2 , i+1 , j, dp);
            x = Math.max(x , solver(s1 , s2 , i, j+1 , dp));
            x = Math.max(x , solver(s1 , s2 , i+1 , j+1 , dp));
        }
        return dp[i][j] =x;
    }
}