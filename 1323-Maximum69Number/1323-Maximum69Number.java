// Last updated: 8/16/2025, 8:57:43 PM
class Solution {
    public int maximum69Number (int num) {
        String s = Integer.toString(num);
        // for(int i = 0 ; i < s.length() ; i++){

        // }
        s = s.replaceFirst("6","9");
        return Integer.parseInt(s);

        
    }
}