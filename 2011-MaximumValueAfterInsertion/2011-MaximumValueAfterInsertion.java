// Last updated: 7/9/2026, 5:14:00 PM
class Solution {
    public String maxValue(String s, int x) {
        StringBuilder sb = new StringBuilder();
        int n = s.length();
        boolean f = true;
        if(s.charAt(0) == '-') for(int i = 0 ; i <n ; i++){
            char ch = s.charAt(i);
            if(ch == '-') sb.append(ch);
            else{
                if(ch-'0' > x && f){
                    sb.append(x);
                    f = false;
                    
                }
                sb.append(ch);
            }
            if(i == n-1 && f){
                sb.append(x);
            }
        }

        else{
            for(int i = 0 ; i <n ; i++){
                char ch = s.charAt(i);
                if(ch-'0' < x && f){
                    sb.append(x);
                    f = false;
                    
                }
                sb.append(ch);
                if(i == n-1 && f){
                    sb.append(x);
                }
            }
        }
        
        return sb.toString();
    }
}