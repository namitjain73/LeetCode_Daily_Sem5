// Last updated: 1/3/2026, 3:09:40 PM
1class Solution {
2    public int longestCommonSubsequence(String text1, String text2) {
3        int[][] dp = new int[text1.length()][text2.length()];
4        for(int[] d : dp) Arrays.fill(d , -1);
5        return solver(text1 , text2 , 0 , 0,dp);
6    }
7    public int solver(String s1 , String s2 , int i , int j,int[][] dp){
8        if(s1.length() == i || s2.length() == j) return 0;
9        if(dp[i][j] != -1) return dp[i][j];
10
11        int take = 0;
12        int skip = 0;
13        if(s1.charAt(i) == s2.charAt(j)){
14            take = solver(s1 , s2 , i+1 , j+1,dp)+1;
15        }else{
16            skip = Math.max(solver(s1 , s2 , i+1 , j,dp),Math.max(solver(s1 , s2 , i , j+1,dp),solver(s1 , s2 , i+1 , j+1,dp)));
17        }
18        return dp[i][j] = Math.max(take,skip);
19    }
20}