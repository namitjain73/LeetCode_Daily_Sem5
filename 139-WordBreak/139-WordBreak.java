// Last updated: 9/11/2025, 11:36:50 PM
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set= new HashSet<>();
        int maxlen = Integer.MIN_VALUE;
        for(String ele : wordDict){
            set.add(ele);
            maxlen =Math.max(maxlen,ele.length());
        }

        int dp[] = new int[s.length()];
        Arrays.fill(dp,-1);
        return helper(s , set , 0 , maxlen , dp) == 1;
        
    }

    public int helper(String s , Set<String> set , int i , int max , int[] dp){
        if(i == s.length()) return 1;
        if(dp[i] != -1) return dp[i];

        String temp = "";
        for(int j=  i ; j < s.length() && (j - i) < max ; j++){
            temp += s.charAt(j);
            if(set.contains(temp) && helper(s,set,j+1,max,dp) == 1){
                dp[i] = 1;
                return 1;
            }
        }
        return dp[i] = 0;
    }
}