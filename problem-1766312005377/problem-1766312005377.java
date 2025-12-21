// Last updated: 12/21/2025, 3:43:25 PM
1class Solution {
2    int t[][];
3    public int minDistance(String word1, String word2) {
4        
5        int ans = LCS(word1,word2);
6
7        int del = word1.length() - ans;
8        int add = word2.length() - ans;
9
10        return del + add; 
11    }
12
13    public int LCS(String word1,String word2){
14        t = new int[word1.length()+1][word2.length()+1];
15
16        for(int i = 0; i<word1.length()+1; i++){
17            for(int j = 0; j<word2.length()+1; j++){
18                if(i == 0 || j == 0){
19                    t[i][j] = 0;
20                }
21            }
22        }
23        for(int i = 1; i<word1.length()+1; i++){
24            for(int j= 1; j<word2.length()+1; j++){
25                if(word1.charAt(i-1) == word2.charAt(j-1)){
26                    t[i][j] = 1 + t[i-1][j-1];
27                }else{
28                    t[i][j] = Math.max(t[i-1][j],t[i][j-1]);
29                }
30            }
31        }
32        return t[word1.length()][word2.length()];
33    }
34}