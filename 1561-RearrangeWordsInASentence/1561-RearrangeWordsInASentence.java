// Last updated: 7/9/2026, 5:16:18 PM
class Solution {
    public String arrangeWords(String text) {
        String[] ans = text.split(" ");
        Arrays.sort(ans , (a,b)->a.length()-b.length());
        StringBuilder sb = new StringBuilder();
        String s1 = Character.toString(ans[0].charAt(0)).toUpperCase();
        s1 += ans[0].substring(1);
        sb.append(s1);
        for(int i = 1 ; i < ans.length ; i++){
            sb.append(" ");
            s1 = Character.toString(ans[i].charAt(0)).toLowerCase();
            s1 += ans[i].substring(1);
            sb.append(s1);
        }
        return sb.toString();
    }
}