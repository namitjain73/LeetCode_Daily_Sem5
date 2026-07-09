// Last updated: 7/9/2026, 5:05:07 PM
class Solution {
    public int findPermutationDifference(String s, String t) {
        int n = 0;
        for(int i = 0 ; i < s.length() ; i++){
            for(int j= 0  ; j < t.length() ; j++){
                if(s.charAt(i) == t.charAt(j)){
                    n += Math.abs(i - j);
                    break;
                }
            }
        }
        return n;
        
    }
}