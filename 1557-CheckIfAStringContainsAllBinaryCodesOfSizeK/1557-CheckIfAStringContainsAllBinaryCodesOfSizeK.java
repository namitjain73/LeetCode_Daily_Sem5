// Last updated: 7/9/2026, 5:16:20 PM
class Solution {
    public boolean hasAllCodes(String s, int k) {
        Set<String> set = new HashSet<>();
        int total = 1 << k;
        for(int i = 0  ; i < s.length() - k + 1 ;  i++){
            set.add(s.substring(i,i+k));
            if(set.size() == total) return true;
        }
        return false;
    }
}