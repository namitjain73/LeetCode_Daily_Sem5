// Last updated: 7/9/2026, 5:25:12 PM
class Solution {
    public int lengthOfLastWord(String s) {
      return cheak(s);  
    }

    public static int cheak(String s){
        char[] ch = s.toCharArray();
        int c= 0 ;
        for(int i = s.length()-1 ; i >= 0 ; i--){
            if(ch[i] == ' '){
                continue;
            }
            else{
                c = search(ch,i);
                break;
            }
        }
        return c;
    }

    public static int search(char[] ch , int k){
        int c= 0;
        for(int i = k ; i >= 0 ; i--){
            if(ch[i] == ' '){
                return c;
            }
            else{
                c++;
            }

        }
        return c;
    }
}