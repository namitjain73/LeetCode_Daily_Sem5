// Last updated: 7/9/2026, 5:26:12 PM
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int l = 0;
        Map<Character,Integer> map = new HashMap<>();
        int ans = 0;
        for(int r = 0 ; r < s.length() ; r++){
            char ch = s.charAt(r);
            if(map.containsKey(ch)){
                while(map.containsKey(ch)){
                    map.put(s.charAt(l) , map.get(s.charAt(l))-1);
                    if(map.get(s.charAt(l)) == 0) map.remove(s.charAt(l));
                    l++;
                }
            }
            map.put(ch,1);

            ans = Math.max(ans , map.size());
        }
        return ans;
    }
}