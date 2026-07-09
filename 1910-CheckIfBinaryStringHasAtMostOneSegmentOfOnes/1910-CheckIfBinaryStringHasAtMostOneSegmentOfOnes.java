// Last updated: 7/9/2026, 5:14:35 PM
class Solution {
    public boolean checkOnesSegment(String s) {
        boolean seenZero = false;

        for(char c : s.toCharArray()) {
            if(c == '0') {
                seenZero = true;
            } else if(seenZero) {
                return false;
            }
        }

        return true;
    }
}