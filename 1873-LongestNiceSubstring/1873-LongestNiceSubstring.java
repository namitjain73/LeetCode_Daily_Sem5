// Last updated: 7/9/2026, 5:14:45 PM
class Solution {
    public String longestNiceSubstring(String s) {
        if(s.length() < 2) return "";
        return solver(s , 0 ,s.length());
    }
    public String solver(String s , int l, int r){
        if(r - l < 2) return "";

        Set<Character> set = new HashSet<>();
        for(int i = l ; i < r ; i++){
            set.add(s.charAt(i));
        }

        for(int i = l ; i < r ; i++){
            if(!set.contains(Character.toLowerCase(s.charAt(i))) || !set.contains(Character.toUpperCase(s.charAt(i)))){
                String left = solver(s , l , i);
                String right = solver(s , i+1 , r);
                return left.length() >= right.length() ? left : right;
            }
        }
        return s.substring(l,r);
    }
}