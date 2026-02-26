// Last updated: 2/26/2026, 8:26:34 PM
1class Solution {
2    public int numSteps(String s) {
3        int steps = 0;
4        int carry = 0;
5
6        for (int i = s.length() - 1; i > 0; i--) {
7            int bit = (s.charAt(i) - '0') + carry;
8
9            if (bit == 1) {     // odd case
10                steps += 2;     // add 1 + divide by 2
11                carry = 1;
12            } else {            // even case
13                steps += 1;     // divide by 2
14            }
15        }
16        return steps + carry;
17    }
18}