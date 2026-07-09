// Last updated: 7/9/2026, 5:20:08 PM
class Solution {
    public String toLowerCase(String s) {
        String s1 = "";
        for(int i = 0 ; i < s.length() ; i++){
            int temp = s.charAt(i);
            if(temp >= 65 && temp <= 90) s1 += (char)(temp + 32);
            else s1 += (char)temp;
        }
        return s1;
        
    }
}