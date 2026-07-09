// Last updated: 7/9/2026, 5:16:17 PM
class Solution {
    public int isPrefixOfWord(String s, String s1) {
        if(!s.contains(s1)){
            return -1;
        }
        List<String> list = new ArrayList<>();
        int j = 0;
        for(int i = 0 ; i < s.length() ; i++){
            if(s.charAt(i) == ' '){
                list.add(s.substring(j,i));
                j = i+1;
            }
            
        }
        list.add(s.substring(j,s.length()));
        for(int i = 0; i < list.size() ; i++){
            String str = list.get(i);
            if(str.contains(s1)){
                if(str.substring(0,s1.length()).equals(s1)){
                    return i+1;
                }
            }
        }
        return -1;
        
    }
}