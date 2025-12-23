// Last updated: 12/23/2025, 3:07:35 PM
1class Solution {
2    public String arrangeWords(String text) {
3        String[] ans = text.split(" ");
4        Arrays.sort(ans , (a,b)->a.length()-b.length());
5        StringBuilder sb = new StringBuilder();
6        String s1 = Character.toString(ans[0].charAt(0)).toUpperCase();
7        s1 += ans[0].substring(1);
8        sb.append(s1);
9        for(int i = 1 ; i < ans.length ; i++){
10            sb.append(" ");
11            s1 = Character.toString(ans[i].charAt(0)).toLowerCase();
12            s1 += ans[i].substring(1);
13            sb.append(s1);
14        }
15        return sb.toString();
16    }
17}