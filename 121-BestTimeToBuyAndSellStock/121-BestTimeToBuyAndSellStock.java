// Last updated: 7/9/2026, 5:24:15 PM
class Solution {
    public int maxProfit(int[] prices) {
        int Buy = prices[0];
        int pro = 0;
        for(int i = 1 ; i < prices.length ; i++){
            if(prices[i] < Buy){
                Buy = prices[i];
            }else if(prices[i] - Buy > pro){
                pro = prices[i] - Buy;
            }
        }
        return pro;
        
    }
}