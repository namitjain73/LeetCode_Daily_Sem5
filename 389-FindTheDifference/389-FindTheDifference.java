// Last updated: 7/9/2026, 5:22:02 PM
class Solution {
    public char findTheDifference(String s, String t) {
        char ans = 0;
        for(char ch : s.toCharArray()) ans ^=  ch;
        for(char ch : t.toCharArray()) ans ^= ch;
        return ans;
    }
}