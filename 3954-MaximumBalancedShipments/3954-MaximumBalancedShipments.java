// Last updated: 7/9/2026, 4:59:44 PM
class Solution {
    public int maxBalancedShipments(int[] weight) {
        int count = 0;
        int max = 0;
        int n = weight.length;
        for(int i = 0 ; i< n ; i++){
            max = Math.max(weight[i] , max);
            if(max > weight[i]){
                max = 0;
                count++;
            }
        }
        

        return count;
    }
}
