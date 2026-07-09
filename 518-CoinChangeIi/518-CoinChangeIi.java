// Last updated: 7/9/2026, 5:21:09 PM
class Solution {
    public int change(int amount, int[] coins) {
        int[][] dp = new int[amount+1][coins.length];
        for(int[] d : dp) Arrays.fill(d , -1);
        return solver(coins , amount , 0,dp);
    }
    public int solver(int[] coins , int amount , int idx,int[][] dp){
        if(amount == 0){
            return 1;
        }
        if(dp[amount][idx] != -1) return dp[amount][idx];

        int ans = 0;
        for(int i = idx ; i < coins.length ; i++){
            if(amount >= coins[i]){
                ans += solver(coins , amount - coins[i] ,i,dp);
            }
        }
        return dp[amount][idx] = ans;
    }
}