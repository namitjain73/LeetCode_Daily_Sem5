// Last updated: 1/5/2026, 8:00:21 AM
1class Solution {
2    public int minDistance(String word1, String word2) {
3        int[][] dp =new int[word1.length()][word2.length()];
4        for(int[] d : dp) Arrays.fill(d,-1);
5        return solver(word1,word2,0,0,dp);
6    }
7    public int solver(String s1 , String s2 , int i , int j,int[][] dp){
8        if(i == s1.length()){
9            return s2.length()-j;
10        }
11        if(j == s2.length()){
12            return s1.length() - i;
13        }
14        if(dp[i][j] != -1) return dp[i][j];
15
16        int ans = 0;
17        if(s1.charAt(i) != s2.charAt(j)){
18            // insert
19            int ins = solver(s1 , s2 , i , j+1,dp);
20            // delete
21            int del = solver(s1 , s2 , i + 1 ,j,dp);
22            // replace
23            int rep = solver(s1 , s2 , i+1 , j+1,dp);
24            ans = Math.min(ins,Math.min(del,rep))+1;
25        }
26        else{
27           ans = solver(s1,s2,i+1,j+1,dp);
28        }
29        return dp[i][j] = ans;
30    }
31}   