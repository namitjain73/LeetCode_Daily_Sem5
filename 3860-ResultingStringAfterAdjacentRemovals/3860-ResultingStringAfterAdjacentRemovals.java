// Last updated: 7/9/2026, 5:00:48 PM
class Solution {
    public String resultingString(String s) {
        StringBuilder sb = new StringBuilder();

        sb.append(s.charAt(0));
        for(int i = 1 ; i < s.length() ; i++){
            if(sb.length() == 0){
                sb.append(s.charAt(i));
                continue;
            }
            char ch1 = sb.charAt(sb.length()-1);
            char ch2 = s.charAt(i);
            if( (ch1 == ch2+1) || (ch1+1 == ch2) || (ch1 == 'a' && ch2 == 'z') || (ch1 == 'z' && ch2 == 'a') ){
                sb.deleteCharAt(sb.length()-1);
            }else{
                sb.append(ch2);
            }
        }
        return sb.toString();
    }
}