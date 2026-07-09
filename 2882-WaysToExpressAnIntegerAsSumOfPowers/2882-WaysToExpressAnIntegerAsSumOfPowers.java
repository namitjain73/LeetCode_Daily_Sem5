// Last updated: 7/9/2026, 5:07:31 PM
class Solution {
    int[][]  dp = new int[301][301];
    int mod = 1_000_000_007;
    public int helper(int n , int num , int x){
        if(n == 0) return 1;
        if(n < 0) return 0;
        int pow = (int)Math.pow(num,x);
        if(pow > n) return 0;
        if(dp[n][num] != -1) return dp[n][num];


        int take = helper(n - pow, num + 1, x);
        int skip = helper(n , num + 1 , x);
        return dp[n][num] = (take + skip)%mod;
    }
    public int numberOfWays(int n, int x) {
        for(int i =0 ; i < dp.length ; i++){
            Arrays.fill(dp[i],-1);
        }


        return helper(n , 1 , x);
    }
}