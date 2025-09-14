// Last updated: 9/15/2025, 2:07:29 AM
class Solution {
    public String[] spellchecker(String[] wordlist, String[] queries) {
        String[] ans = new String[queries.length];
        Set<String> set = new HashSet<>();
        Map<String,String> lower = new HashMap<>();
        Map<String,String> vowel = new HashMap<>();
        for(String s : wordlist){
            String low = s.toLowerCase();
            set.add(s);
            if(!lower.containsKey(low)) lower.put(low,s);
            String str = v(low);
            if(containsvowel(s) && !vowel.containsKey(str)) vowel.put(str,s);
        }
        int i = 0;

        for(String s : queries){
            String low = s.toLowerCase();
            String str = v(low);
            if(set.contains(s)){
                ans[i++] = s;
            }
            else if(lower.containsKey(low)){
                ans[i++] = lower.get(low);
            }
            else if(containsvowel(low) && vowel.containsKey(str)){
                ans[i++] = vowel.get(str);
            }else{
                ans[i++] = "";
            }
        }
        return ans;
    }

    public static String v(String s){
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < s.length() ; i++){
            char ch = s.charAt(i);
            if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u'){
                sb.append("*");
            }else{
                sb.append(ch);
            }
        }
        return sb.toString();
    }
    public static boolean containsvowel(String s){
        for(int i = 0; i < s.length() ; i++){
            char ch = s.charAt(i);
            if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u'){
                return true;
            }
        }
        return false;
    }
}