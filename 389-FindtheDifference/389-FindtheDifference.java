// Last updated: 3/25/2026, 1:57:05 AM
1class Solution {
2    public char findTheDifference(String s, String t) {
3        char ans = 0;
4        for(char ch : s.toCharArray()) ans ^=  ch;
5        for(char ch : t.toCharArray()) ans ^= ch;
6        return ans;
7    }
8}