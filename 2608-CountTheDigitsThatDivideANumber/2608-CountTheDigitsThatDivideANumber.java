// Last updated: 7/9/2026, 5:08:59 PM
class Solution {
    public int countDigits(int num) {
        int copy = num;
        int n = 0;
        while(num > 0){
            int rem  = num % 10;
            num = num / 10;
            if(rem != 0 && copy % rem == 0) n++; 
        }
        return n;
        
    }
}