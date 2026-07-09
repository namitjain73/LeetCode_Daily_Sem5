// Last updated: 7/9/2026, 5:12:06 PM
class Solution {
    public String addSpaces(String s, int[] spaces) {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        int n = spaces.length;
        for(int j : spaces){
            sb.append(s.substring(i,j) + " ");
            i = j;
        }
        sb.append(s.substring(i,s.length()));
        return sb.toString();
        
    }
}