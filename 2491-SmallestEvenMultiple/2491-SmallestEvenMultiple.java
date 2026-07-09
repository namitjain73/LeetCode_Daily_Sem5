// Last updated: 7/9/2026, 5:09:49 PM
class Solution {
    public int smallestEvenMultiple(int n) {
        // int n = 0;
        for(int i = 1 ;i <= n*2 ; i++){
            if(i % n == 0 && i % 2 == 0){
                return i;
            }
        }
        return n*2;
        
    }
}