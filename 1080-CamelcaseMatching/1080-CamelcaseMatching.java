// Last updated: 7/9/2026, 5:18:04 PM
class Solution {
    public List<Boolean> camelMatch(String[] queries, String pattern) {
        List<Boolean> ll = new ArrayList<>();
        for(String s : queries){
            ll.add(valid(s , pattern));
        }
        return ll;
    }
    public boolean valid(String str , String p){
        int l = 0; //str
        int r = 0; //p
        while(l < str.length()){
            if(r < p.length() && str.charAt(l) == p.charAt(r)){
                r++;
            }else if(Character.isUpperCase(str.charAt(l))) return false;
            l++;
        }

        return r == p.length();
    }
}