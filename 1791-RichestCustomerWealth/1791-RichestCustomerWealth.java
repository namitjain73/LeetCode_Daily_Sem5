// Last updated: 7/9/2026, 5:14:59 PM
class Solution {
    public int maximumWealth(int[][] accounts) {
        int max = 0;
        for(int i = 0 ; i < accounts.length ; i++){
            int ans = 0;
            for(int j = 0; j < accounts[0].length ; j++){
                ans += accounts[i][j];
            }
            max = Math.max(max,ans);
        }
        return max;
    }
}