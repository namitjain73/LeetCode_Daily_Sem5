// Last updated: 9/12/2025, 12:47:02 PM
class Solution {
    public boolean doesAliceWin(String s) {
        for(int i = 0 ;i < s.length() ; i++){
            char ch = s.charAt(i);
            if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') return true;

        }

        return false;
        
    }
}