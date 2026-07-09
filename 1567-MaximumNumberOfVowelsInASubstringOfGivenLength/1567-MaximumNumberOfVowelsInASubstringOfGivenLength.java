// Last updated: 7/9/2026, 5:16:15 PM
class Solution {
    public int maxVowels(String s, int k) {
        int ans = 0;
        int vowel = 0;
        for(int i = 0; i < k ;i++){
            if(str(s.charAt(i))){
                vowel++;
            }
        }
        ans = vowel;
        for(int i = k ; i < s.length() ;i++){
            if(str(s.charAt(i))){
                vowel++;
            }
            if(str(s.charAt(i-k))){
                vowel--;
            }
            ans = Math.max(ans,vowel);
        }
        return ans;
        
    }
    public static boolean str(char ch){
        if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u'){
            return true;
        }
        return false;
    }
}