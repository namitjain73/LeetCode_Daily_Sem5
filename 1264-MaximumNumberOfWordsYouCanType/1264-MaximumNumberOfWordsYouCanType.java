// Last updated: 7/9/2026, 5:17:39 PM
class Solution {
    public int canBeTypedWords(String text, String brokenLetters) {
        int[] arr = new int[26];
        for(char ch : brokenLetters.toCharArray()){
            arr[ch-'a']++;
        }

        int count = 0;
        boolean ok = true;

        for(int i = 0; i <= text.length(); i++){
            if(i < text.length() && text.charAt(i) != ' '){
                if(arr[text.charAt(i)-'a'] != 0){
                    ok = false;
                }
            }else{
                if(ok) count++;
                ok = true;
            }
        }
        return count;
    }
}