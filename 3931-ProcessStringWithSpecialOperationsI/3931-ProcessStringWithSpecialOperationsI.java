// Last updated: 7/9/2026, 5:00:09 PM
class Solution {
    public String processStr(String s) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < s.length() ; i++){
            char ch = s.charAt(i);
            if(ch == '%'){
                if(sb.length() == 0)continue;
                sb = sb.reverse();
            }else if(ch == '*'){
                if(sb.length() == 0)continue;
                sb.deleteCharAt(sb.length()-1);
            }else if(ch == '#'){
                if(sb.length() == 0)continue;
                sb = new StringBuilder(sb.toString() + sb.toString());
            }else sb.append(ch);
        }
        return sb.toString();
    }
}