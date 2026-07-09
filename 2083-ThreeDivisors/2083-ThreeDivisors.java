// Last updated: 7/9/2026, 5:13:33 PM
class Solution {
    public boolean isThree(int n) {
        int x = 0;
        for(int i = 2 ; i < n ; i++){
            if(n % i == 0){
                x++;
            }
        }
        if(x == 1) return true;
        return false;
        
    }
}