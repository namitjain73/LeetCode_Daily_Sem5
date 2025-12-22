// Last updated: 12/22/2025, 9:48:08 PM
1class Solution {
2    public String generateTag(String s) {
3        s = s.trim();
4        if(s.length() == 0) return "#";
5        StringBuilder sb = new StringBuilder("#");
6        sb.append(Character.toString(s.charAt(0)).toLowerCase());
7        for(int i = 1 ; i < s.length(); i++){
8            if(s.charAt(i) == ' ') {
9                continue;
10            }
11            if(s.charAt(i-1) == ' '){
12                sb.append(Character.toString(s.charAt(i)).toUpperCase());
13            }else {
14                sb.append(Character.toString(s.charAt(i)).toLowerCase());
15            }
16            if(sb.length() == 100) break;
17        }
18
19        return sb.toString();
20    }
21}
22