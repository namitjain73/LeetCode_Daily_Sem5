// Last updated: 7/9/2026, 5:20:18 PM
class Solution {
    public int minimumDeleteSum(String s1, String s2) {
        int[][] dp = new int[s1.length()][s2.length()];
        for(int[] d : dp) Arrays.fill(d , -1);
        return solver(s1 , s2 , 0 , 0 , dp);
    }

    public int solver(String s1 , String s2 , int i, int j , int[][] dp){
        if(i >= s1.length() && j >= s2.length()) return 0;
        if(i >= s1.length()){
            int n = 0;
            while(j < s2.length()) {
                n += s2.charAt(j);
                j++;
            }
            return n;
        }
        if(j >= s2.length()){
            int n = 0;
            while(i < s1.length()){
                n += s1.charAt(i);
                i++;
            }
                
            return n;
        }
        if(dp[i][j] != -1) return dp[i][j];



        int sum=0;
        if(s1.charAt(i) == s2.charAt(j)){
            sum =  solver(s1, s2 , i +1 , j + 1 , dp);
        }else{
            sum = solver(s1 , s2, i+1 , j , dp) + s1.charAt(i);
            sum = Math.min(sum,solver(s1 , s2 , i , j+1 , dp)+s2.charAt(j));
        }
        return dp[i][j] = sum;
    }
}