// Last updated: 7/9/2026, 5:14:41 PM
class Solution {
    public String largestMerge(String w1, String w2) {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        int j = 0;
        int n = w1.length();
        int m = w2.length();


        while(i < n && j < m){
            if(w1.substring(i).compareTo(w2.substring(j))>0){
                sb.append(w1.charAt(i));
                i++;
            }else{
                sb.append(w2.charAt(j));
                j++;
            }
        }

        if(i < n) sb.append(w1.substring(i));
        if(j < m) sb.append(w2.substring(j));
        return sb.toString();
    }
}