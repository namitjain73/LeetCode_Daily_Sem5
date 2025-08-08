// Last updated: 8/8/2025, 9:14:46 PM
class Solution {
    double dp[][];
    int op[][] = {{100,0},{75,25},{50,50},{25,75}};
    public double rec(int a , int b){
        if(a <= 0 && b <= 0){
            return 0.5;
        }
        if(a <= 0) return 1;
        if(b <= 0) return 0.0;

        if(dp[a][b] != -1) return dp[a][b];
        double pob = 0;

        for(int[] i : op){
            pob += rec(a - i[0] , b - i[1]);
        }

        return dp[a][b] = pob * 0.25;
        

    }
    public double soupServings(int n) {
        if(n >=  5000) return 1;
        dp = new double[n+1][n+1];
        for(int i = 0 ; i <= n ; i++){
            Arrays.fill(dp[i],-1.0);
        }
        return rec(n,n);
    }
}