// Last updated: 7/9/2026, 5:25:43 PM
class Solution {
    public int strStr(String s1, String s2) {
        if(!s1.contains(s2)) return -1;
        if(s1.length() < s2.length()) return -1;

        for(int i = 0 ; i < s1.length() ; i++){
            if(s1.charAt(i) == s2.charAt(0)){
                if(s1.substring(i,i+s2.length()).equals(s2)){
                    return i;
                }
            }
        }
        return -1;
        
    }
}