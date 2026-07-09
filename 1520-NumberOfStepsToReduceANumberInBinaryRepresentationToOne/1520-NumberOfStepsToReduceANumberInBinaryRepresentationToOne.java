// Last updated: 7/9/2026, 5:16:30 PM
class Solution {
    public int numSteps(String s) {
        int steps = 0;
        int carry = 0;

        for (int i = s.length() - 1; i > 0; i--) {
            int bit = (s.charAt(i) - '0') + carry;

            if (bit == 1) {     // odd case
                steps += 2;     // add 1 + divide by 2
                carry = 1;
            } else {            // even case
                steps += 1;     // divide by 2
            }
        }
        return steps + carry;
    }
}