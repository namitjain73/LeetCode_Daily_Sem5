// Last updated: 7/9/2026, 5:22:20 PM
class Solution {
    public void reverseString(char[] s) {
        int i = 0;
        int j = s.length - 1;
        while(i < j){
            char ch = s[i];
            s[i] = s[j];
            s[j] = ch;
            i++;
            j--;
        }
        
    }
}