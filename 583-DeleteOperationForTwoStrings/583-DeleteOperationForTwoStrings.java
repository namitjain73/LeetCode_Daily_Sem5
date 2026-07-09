// Last updated: 7/9/2026, 5:20:47 PM
class Solution {
    int t[][];
    public int minDistance(String word1, String word2) {
        
        int ans = LCS(word1,word2);

        int del = word1.length() - ans;
        int add = word2.length() - ans;

        return del + add; 
    }

    public int LCS(String word1,String word2){
        t = new int[word1.length()+1][word2.length()+1];

        for(int i = 0; i<word1.length()+1; i++){
            for(int j = 0; j<word2.length()+1; j++){
                if(i == 0 || j == 0){
                    t[i][j] = 0;
                }
            }
        }
        for(int i = 1; i<word1.length()+1; i++){
            for(int j= 1; j<word2.length()+1; j++){
                if(word1.charAt(i-1) == word2.charAt(j-1)){
                    t[i][j] = 1 + t[i-1][j-1];
                }else{
                    t[i][j] = Math.max(t[i-1][j],t[i][j-1]);
                }
            }
        }
        return t[word1.length()][word2.length()];
    }
}