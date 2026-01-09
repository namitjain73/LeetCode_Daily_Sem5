// Last updated: 1/9/2026, 11:42:45 PM
1class Solution {
2    public List<String> getWordsInLongestSubsequence(String[] words, int[] groups) {
3        int[][] dp = new int[words.length][2];
4        for(int i=0 ; i<words.length ; i++){
5            dp[i][0] = 1;
6            dp[i][1] = i;
7        }
8        for(int i=0 ; i<words.length; i++){
9            for(int j=i-1 ; j>=0 ; j--){
10                if(groups[i]!=groups[j] && dist(words[i],words[j]) && dp[j][0]+1>dp[i][0]){
11                    dp[i][0] = dp[j][0]+1;
12                    dp[i][1] = j;
13                }
14            }
15        }
16        int idx=0;
17        for(int i=0 ; i<words.length ; i++){
18            if(dp[i][0]>dp[idx][0]){
19                idx = i;
20            }
21        }
22
23        List<String> ans = new ArrayList<>();
24        int temp=idx;
25        for(int i=0 ; i<dp[idx][0] ; i++){
26            ans.add(0,words[temp]);
27            temp = dp[temp][1];
28        }
29        return ans;
30    }
31    public boolean dist(String s1,String s2){
32        if(s1.length()!=s2.length()) return false;
33        boolean flag = true;
34        for(int i=0 ; i<s1.length() ; i++){
35            if(s1.charAt(i)!=s2.charAt(i)){
36                if(flag) flag = false;
37                else return false;
38            }
39        }
40        return true;
41    }
42}