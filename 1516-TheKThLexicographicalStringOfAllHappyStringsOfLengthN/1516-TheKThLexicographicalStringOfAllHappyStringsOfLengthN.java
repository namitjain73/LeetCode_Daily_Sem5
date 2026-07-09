// Last updated: 7/9/2026, 5:16:32 PM
class Solution {
    int x;
    public String getHappyString(int n, int k) {
        char[] ch = {'a','b','c'};
        x = k-1;
        return solver(ch , n , k , "");
    }
    public String solver(char[] ch , int n , int k , String str){
        if(x == 0 && str.length() == n){
            // System.out.println(str + " ans");
            return str;
        }
        if(str.length() == n){
            // System.out.println(str);
            x--;
            return "";
        }

        for(int i = 0 ; i < 3 ; i++){
            if(str.length() == 0 || ch[i] != str.charAt(str.length()-1)){
                String ans = solver(ch , n , k , str + ch[i]);
                if(ans.length() > 0){
                    return ans;
                }
            }
        }
        return "";
    }
}