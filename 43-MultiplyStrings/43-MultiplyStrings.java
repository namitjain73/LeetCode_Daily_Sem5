// Last updated: 7/9/2026, 5:25:30 PM
import java.math.*;
class Solution {
    public String multiply(String num1, String num2) {
        BigInteger n = new BigInteger(num1);
        BigInteger m = new BigInteger(num2);
        BigInteger ans = m.multiply(n);
        return ans.toString();
        
    }
}