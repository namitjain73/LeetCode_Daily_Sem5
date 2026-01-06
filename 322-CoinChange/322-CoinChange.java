// Last updated: 1/6/2026, 1:04:33 PM
1class Solution {
2    public int change(int amount, int[] coins) {
3        int[][] dp = new int[amount+1][coins.length];
4        for(int[] d : dp) Arrays.fill(d , -1);
5        return solver(coins , amount , 0,dp);
6    }
7    public int solver(int[] coins , int amount , int idx,int[][] dp){
8        if(amount == 0){
9            return 1;
10        }
11        if(dp[amount][idx] != -1) return dp[amount][idx];
12
13        int ans = 0;
14        for(int i = idx ; i < coins.length ; i++){
15            if(amount >= coins[i]){
16                ans += solver(coins , amount - coins[i] ,i,dp);
17            }
18        }
19        return dp[amount][idx] = ans;
20    }
21}