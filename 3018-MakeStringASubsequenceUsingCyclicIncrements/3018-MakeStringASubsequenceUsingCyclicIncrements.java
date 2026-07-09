// Last updated: 7/9/2026, 5:07:12 PM
class Solution {
    public boolean canMakeSubsequence(String str1, String str2) {
        char[] ch = str1.toCharArray();
        char[] ch1 = str2.toCharArray();
        return cheak(ch,ch1);
        
    }
 public static boolean cheak(char[] ch,char[] ch1){
        int n = ch.length;
        int m = ch1.length;
        int c = 0;
        if(n < m){
            return false;
        }
        int j = 0;
        for(int i = 0 ; i < n ; i++){
            if(ch[i] == ch1[j]){
                c++;
                j++;
                if(j == m){
                break;
            }
            }
            else if(ch[i]+1 == ch1[j]){
                c++;
                j++;
                if(j == m){
                break;
            }
            }
            else if(ch[i] == 'z' && ch1[j] == 'a'){
                c++;
                j++;
                if(j == m){
                break;
            }
            }
            
        }
        if(c == m){
            return true;
        }
        return false;
    }
}