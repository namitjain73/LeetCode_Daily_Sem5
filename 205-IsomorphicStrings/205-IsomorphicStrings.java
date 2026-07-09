// Last updated: 7/9/2026, 5:23:23 PM
class Solution {
    public boolean isIsomorphic(String s, String t) {
        Map< Character ,Character> map1 = new HashMap<>();
        Map< Character ,Character> map2 = new HashMap<>();

        for(int i = 0 ; i < s.length() ; i++){
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);
            if(map1.containsKey(c1)){
                if(map1.get(c1) != c2) return false;
            }else{
                map1.put(c1,c2);
            }

            if(map2.containsKey(c2)){
                if(map2.get(c2) != c1) return false;
            }else{
                map2.put(c2,c1);
            }
        }
        return true;
    }
}