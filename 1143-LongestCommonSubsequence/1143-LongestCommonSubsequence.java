// Last updated: 6/24/2026, 12:40:30 PM
1class Solution {
2    public int longestCommonSubsequence(String s1, String s2) {
3        int n = s1.length();
4        int m = s2.length();
5        int[][] dp = new int[n][m];
6        for(int[] d : dp) Arrays.fill(d , -1);
7        return solver(s1 , s2 , 0 , 0 , dp);
8    }
9    public int solver(String s1 , String s2 , int i , int j , int[][] dp){
10        if(i >= s1.length() || j >= s2.length()) return 0;
11        if(dp[i][j] != -1) return dp[i][j];
12
13        int x = 0;
14        if(s1.charAt(i) == s2.charAt(j)){
15            return dp[i][j] = solver(s1 , s2 , i+1 , j+1 , dp) + 1;
16        }else{
17            x = solver(s1, s2 , i+1 , j, dp);
18            x = Math.max(x , solver(s1 , s2 , i, j+1 , dp));
19            x = Math.max(x , solver(s1 , s2 , i+1 , j+1 , dp));
20        }
21        return dp[i][j] =x;
22    }
23}