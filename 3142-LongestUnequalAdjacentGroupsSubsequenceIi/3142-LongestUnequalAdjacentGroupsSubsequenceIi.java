// Last updated: 7/9/2026, 5:06:56 PM
class Solution {
    public List<String> getWordsInLongestSubsequence(String[] words, int[] groups) {
        int[][] dp = new int[words.length][2];
        for(int i=0 ; i<words.length ; i++){
            dp[i][0] = 1;
            dp[i][1] = i;
        }
        for(int i=0 ; i<words.length; i++){
            for(int j=i-1 ; j>=0 ; j--){
                if(groups[i]!=groups[j] && dist(words[i],words[j]) && dp[j][0]+1>dp[i][0]){
                    dp[i][0] = dp[j][0]+1;
                    dp[i][1] = j;
                }
            }
        }
        int idx=0;
        for(int i=0 ; i<words.length ; i++){
            if(dp[i][0]>dp[idx][0]){
                idx = i;
            }
        }

        List<String> ans = new ArrayList<>();
        int temp=idx;
        for(int i=0 ; i<dp[idx][0] ; i++){
            ans.add(0,words[temp]);
            temp = dp[temp][1];
        }
        return ans;
    }
    public boolean dist(String s1,String s2){
        if(s1.length()!=s2.length()) return false;
        boolean flag = true;
        for(int i=0 ; i<s1.length() ; i++){
            if(s1.charAt(i)!=s2.charAt(i)){
                if(flag) flag = false;
                else return false;
            }
        }
        return true;
    }
}