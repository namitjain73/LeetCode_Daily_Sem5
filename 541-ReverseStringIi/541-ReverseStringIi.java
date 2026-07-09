// Last updated: 7/9/2026, 5:20:59 PM
class Solution {
    public String reverseStr(String s, int k) {
        StringBuilder sb = new StringBuilder();
        boolean f= true;
        for(int i = 0 ; i <= s.length() ; i += k){
            if(i+k >= s.length()){
                if(f){
                    StringBuilder sb2= new StringBuilder(s.substring(i));
                    sb.append(sb2.reverse().toString());
                }else{
                    sb.append(s.substring(i));
                }
            }else if(f){
                StringBuilder sb2= new StringBuilder(s.substring(i,i+k));
                sb.append(sb2.reverse().toString());
                f = false;
            }else{
                sb.append(s.substring(i, i+k));
                f = true;
            }
        }
        return sb.toString();
    }
}