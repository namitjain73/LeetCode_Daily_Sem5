// Last updated: 7/9/2026, 5:11:01 PM
class Solution {
    public String removeDigit(String s, char digit) {
        String s1 = "";
        for(int i = 0 ; i < s.length()-1 ; i++){
            if(s.charAt(i) == digit && (s.charAt(i)-'0') < (s.charAt(i+1)-'0') ){
                s1 = s.substring(0,i)+s.substring(i+1);
                break;
            }
        }
        if(s1.length()==0){
          for(int i = s.length()-1 ; i >= 0 ; i--){
            if(s.charAt(i) == digit ){
                s1 = s.substring(0,i)+s.substring(i+1);
                break;
            }
        }  
        }
        return s1;
    }
}