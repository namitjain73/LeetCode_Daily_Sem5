// Last updated: 7/9/2026, 5:07:54 PM
class Solution {
    public int minLength(String s) {
            while(s.contains("AB") || s.contains("CD")){
                s = s.replace("AB","");
                s = s.replace("CD","");
            }
        return s.length();
        
    }
}