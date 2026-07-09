// Last updated: 7/9/2026, 5:17:47 PM
class Solution {
    public String defangIPaddr(String address) {
        return str(address);
    }
    public static String str(String s)
    {
        String s1 = "";
        for(int i = 0 ; i < s.length() ;i++){
            if(s.charAt(i) == '.'){
                s1+="[.]";
            }
            else{
                s1+=Character.toString(s.charAt(i));
            }
        }
        return s1;
    }
}