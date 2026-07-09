// Last updated: 7/9/2026, 5:04:55 PM
class Solution {
    public boolean doesAliceWin(String s) {
        for(int i = 0 ;i < s.length() ; i++){
            char ch = s.charAt(i);
            if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') return true;

        }

        return false;
        
    }
}