// Last updated: 7/9/2026, 5:21:18 PM
class Solution {
    public String kthSmallestPath(int[] destination, int k) {
        
        int ti = destination[0], tj = destination[1];
        int[][] dp = new int[ti+1][tj+1];
        for(int i = ti; i >= 0; i--){
            for(int j = tj; j >= 0; j--){
                if(i == ti && j == tj){
                    dp[i][j] = 1;
                }else if(i == ti){
                    dp[i][j] = dp[i][j+1];
                }else if(j == tj){
                    dp[i][j] = dp[i+1][j];
                }else{
                    dp[i][j] = dp[i+1][j] + dp[i][j+1];
                }
            }
        }
     
        StringBuilder sb = new StringBuilder();
        helper(dp, 0, 0, k, sb);
        return sb.toString();
    }
    
    private void helper(int[][] dp, int i, int j, int k, StringBuilder sb){
        
        if(i == dp.length -1){
            while(++j < dp[0].length)sb.append("H");
            return;
        }
        if(j == dp[0].length - 1){
            
            while(++i < dp.length)sb.append("V");
            return;
        }
        if(dp[i][j+1] >= k){
          
            sb.append("H");
            helper(dp, i, j+1, k, sb);
        }else{
       
            sb.append("V");
            helper(dp, i+1, j, k-dp[i][j+1], sb);
        }
    }
}