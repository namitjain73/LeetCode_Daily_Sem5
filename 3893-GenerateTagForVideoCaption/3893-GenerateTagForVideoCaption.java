// Last updated: 7/9/2026, 5:00:22 PM
class Solution {
    public String generateTag(String s) {
        s = s.trim();
        if(s.length() == 0) return "#";
        StringBuilder sb = new StringBuilder("#");
        sb.append(Character.toString(s.charAt(0)).toLowerCase());
        for(int i = 1 ; i < s.length(); i++){
            if(s.charAt(i) == ' ') {
                continue;
            }
            if(s.charAt(i-1) == ' '){
                sb.append(Character.toString(s.charAt(i)).toUpperCase());
            }else {
                sb.append(Character.toString(s.charAt(i)).toLowerCase());
            }
            if(sb.length() == 100) break;
        }

        return sb.toString();
    }
}
