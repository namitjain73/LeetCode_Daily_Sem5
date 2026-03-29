// Last updated: 3/29/2026, 10:48:13 PM
1class Solution {
2    public boolean canBeEqual(String s1, String s2) {
3        boolean even = (s1.charAt(0) == s2.charAt(0) && s1.charAt(2) == s2.charAt(2)) ||
4                       (s1.charAt(0) == s2.charAt(2) && s1.charAt(2) == s2.charAt(0));
5        boolean odd = (s1.charAt(1) == s2.charAt(1) && s1.charAt(3) == s2.charAt(3)) ||
6                      (s1.charAt(1) == s2.charAt(3) && s1.charAt(3) == s2.charAt(1));
7
8        return even && odd;
9    }
10}