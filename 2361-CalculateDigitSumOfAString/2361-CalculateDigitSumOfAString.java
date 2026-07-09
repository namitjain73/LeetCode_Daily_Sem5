// Last updated: 7/9/2026, 5:10:47 PM
class Solution {
    public String digitSum(String s, int k) {
        String s1 = "";
        while(s.length() > k){
            for(int i = 0 ; i < s.length() ;){
                if((i + k) > s.length() -1 ){
                    s1 += add(s.substring(i,s.length()));
                    break;
                }
                else{
                    
                    s1 += add(s.substring(i,i+k));
                    i += k;


                }

            }
            s = s1;
            s1 = "";

        }
        return s;
        
    }

    public static String add(String s){
        int n = 0;
        for(int i = 0 ; i < s.length() ;i++){
            n += s.charAt(i) - '0';
        }
        return Integer.toString(n);
    }
}