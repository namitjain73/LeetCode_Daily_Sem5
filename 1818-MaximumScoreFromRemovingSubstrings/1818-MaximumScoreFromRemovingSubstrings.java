// Last updated: 7/9/2026, 5:14:51 PM
class Solution {
    public int maximumGain(String s, int x, int y) {
        String top = "ab";
        String bot = "ba";
        if(y > x){
            bot = "ab";
            top = "ba";
            int temp = x;
            x = y;
            y = temp;
        }


        int res = 0;
        StringBuilder sb = new StringBuilder();

        for(char ch : s.toCharArray()){
            if(ch == top.charAt(1) && sb.length() > 0 && sb.charAt(sb.length()-1) == top.charAt(0)){
                res += x;
                sb.setLength(sb.length()-1);
            }else{
                sb.append(ch);
            }
        } 

        StringBuilder sb1 = new StringBuilder();

        for(char ch : sb.toString().toCharArray()){
            if(ch == bot.charAt(1) && sb1.length() > 0 && sb1.charAt(sb1.length()-1) == bot.charAt(0)){
                res += y;
                sb1.setLength(sb1.length()-1);
            }else{
                sb1.append(ch);
            }
        } 
        return res;      
    }
}