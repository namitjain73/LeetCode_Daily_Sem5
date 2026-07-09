// Last updated: 7/9/2026, 5:21:46 PM
import java.math.*;
class Solution {
    public String addStrings(String num1, String num2) {
        BigInteger a = new BigInteger(num1);
        BigInteger b = new BigInteger(num2);
        BigInteger c = a.add(b);
        return c.toString();
        
    }
}