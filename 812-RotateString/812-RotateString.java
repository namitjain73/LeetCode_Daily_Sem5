// Last updated: 7/9/2026, 5:19:36 PM
class Solution {
    public boolean rotateString(String s, String goal) {
        if(s.length() != goal.length()) return false;

        return (s+s).contains(goal);
    }
}