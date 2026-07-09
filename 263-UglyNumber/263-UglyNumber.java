// Last updated: 7/9/2026, 5:22:43 PM
class Solution {
    public boolean isUgly(int num) {
        for(int i = 2 ; i < 6 && num > 0; i++){
            while(num % i == 0){
                num = num / i;
            }
        }
        return num == 1;
        
    }
}