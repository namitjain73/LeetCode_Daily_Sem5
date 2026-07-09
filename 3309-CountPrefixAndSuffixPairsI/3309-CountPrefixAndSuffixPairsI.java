// Last updated: 7/9/2026, 5:06:00 PM
class Solution {
    public int countPrefixSuffixPairs(String[] words) {
        int c = 0;
        for(int i = 0; i < words.length; i++) {
            for(int j = i+1; j < words.length; j++) {
                if (words[i].length() <= words[j].length()) {
                    if (isPrefixAndSuffix(words[i], words[j])) {
                        c++;
                    }
                }
            }
        }
        return c;
    }

    public static boolean isPrefixAndSuffix(String str1 , String str2){
        for (int i = 0; i < str1.length(); i++) {
            if (str1.charAt(i) != str2.charAt(i)) {
                return false;
            }
        }
        int j = str2.length()-1;
        for(int i = str1.length() - 1; i >= 0; i--){
            if(str1.charAt(i) != str2.charAt(j)){
                return false;
            }
            j--;
        }
        return true;
    }
}