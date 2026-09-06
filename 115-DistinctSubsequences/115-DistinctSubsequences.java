// Last updated: 9/6/2026, 4:06:42 PM
1class Solution {
2    public int numDistinct(String s, String t) {
3        int[][] dp = new int[s.length()][t.length()];
4        for(int[] d : dp) Arrays.fill(d , -1);
5        int ans = solver(s , t , 0 , 0  , dp);
6        return ans;
7    }
8    public int solver(String s , String t , int i,  int j , int[][] dp){
9        if(j == t.length()) return 1;
10        if(i >= s.length() || j >= t.length()) return 0;
11        if(dp[i][j] != -1) return dp[i][j];
12
13        int ans = 0;
14        if(s.charAt(i) == t.charAt(j)){
15            ans = solver(s , t , i+1 , j+1 , dp);
16        }
17        ans += solver(s , t , i+1 , j , dp);
18        
19        return dp[i][j] = ans;
20    }
21}