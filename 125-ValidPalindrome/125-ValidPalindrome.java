// Last updated: 7/9/2026, 5:24:10 PM
class Solution {
    public boolean isPalindrome(String s) {
        return palindrom(onlylower(tolower(s)));
        
    }
    public  static String tolower(String s){
        String sb = "";
        for(int i = 0 ; i < s.length() ; i++){
            if(s.charAt(i) >= 65 && s.charAt(i) <= 90){
                sb += Character.toString(s.charAt(i)+32);
            }
            else{
                sb += Character.toString(s.charAt(i));
            }
       }
       return sb;
    }

    public  static String onlylower(String s){
        String sb = "";
        for(int i = 0 ; i < s.length() ; i++){
            if((s.charAt(i) >= 97 && s.charAt(i) <= 122) || (s.charAt(i) >= 48 && s.charAt(i) <= 57)){
                sb += Character.toString(s.charAt(i));
            }
       }
       return sb;
    }

        public  static boolean palindrom(String s){
            // if(s.length() == 1 || s.length() == 1){
            //     return false;
            // }
        int lo = 0 ;
        int hi = s.length()-1;
        while(lo < hi){
            if(s.charAt(lo) != s.charAt(hi)){
                return false;
            }
            lo++;
            hi--;
        }
        return true;
    }
}