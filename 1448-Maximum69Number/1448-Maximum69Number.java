// Last updated: 7/9/2026, 5:16:50 PM
class Solution {
    public int maximum69Number (int num) {
        String s = Integer.toString(num);
        // for(int i = 0 ; i < s.length() ; i++){

        // }
        s = s.replaceFirst("6","9");
        return Integer.parseInt(s);

        
    }
}