// Last updated: 7/9/2026, 5:21:10 PM
class Solution {
    public boolean checkPerfectNumber(int num) {
        int n = 0;
        for(int i=1 ; i < num ; i++){
            if(num % i == 0){
                n += i;
            }
        }
        return n == num;
        
    }
}