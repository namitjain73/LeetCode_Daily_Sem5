// Last updated: 7/9/2026, 5:01:41 PM
class Solution {
    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        int n = baskets.length;
        int c =0;
        for(int i = 0 ;  i < n ; i++){
            for(int j = 0 ; j < n ; j++){
                if(fruits[i] <= baskets[j]) {
                    c++;
                    baskets[j]= 0;
                    break;
                }
            }
        }
        return n-c;
        
    }
}