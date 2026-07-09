// Last updated: 7/9/2026, 5:08:44 PM
class Solution {
    public int alternateDigitSum(int n) {
        int c= 0;
        int mul = 1;
        String s = Integer.toString(n);
        if(s.length() % 2 == 0){
            mul = -1;
        }
        while(n > 0){
            int rem = n % 10;
            n = n / 10;
            c = c + rem*mul;
            mul = mul * -1;
        }
        return c;
        
    }
}
