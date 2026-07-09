// Last updated: 7/9/2026, 5:21:36 PM
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> list = new ArrayList<>();
        int[] par = new int[26];
        for(int i = 0 ; i < p.length() ; i++){
            par[p.charAt(i) - 'a']++;
        }
        if(p.length() > s.length()){
            return list;
        }

        for(int i = 0 ; i < s.length() - p.length() + 1 ; i++){
            String as = s.substring(i , i+p.length());
            if(cheak(as , par)){
                list.add(i);
            }
        }
        return list;
    }

    public boolean cheak(String s , int[] p){
        int[] str = new int[26];
        for(int i = 0 ; i < s.length() ; i++){
            str[s.charAt(i) - 'a']++;
        }

        for(int i = 0 ; i < 26 ; i++){
            if(str[i] != p[i]){
                return false;
            }
        }
        return true;
    }
}