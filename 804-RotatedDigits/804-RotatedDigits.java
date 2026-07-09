// Last updated: 7/9/2026, 5:19:37 PM
class Solution {
    public int rotatedDigits(int n) {
        int count = 0;
        
        for (int num = 1; num <= n; num++) {
            String s = String.valueOf(num);
            boolean isValid = true;
            boolean isGood = false;
            
            for (char ch : s.toCharArray()) {
                if (ch == '3' || ch == '4' || ch == '7') {
                    isValid = false;
                    break;
                }
                if (ch == '2' || ch == '5' || ch == '6' || ch == '9') {
                    isGood = true;
                }
            }
            
            if (isValid && isGood) {
                count++;
            }
        }
        
        return count;
    }
}