// Last updated: 6/16/2026, 10:58:29 PM
1class Solution {
2    public String processStr(String s) {
3        StringBuilder sb = new StringBuilder();
4        for(int i = 0 ; i < s.length() ; i++){
5            char ch = s.charAt(i);
6            if(ch == '%'){
7                if(sb.length() == 0)continue;
8                sb = sb.reverse();
9            }else if(ch == '*'){
10                if(sb.length() == 0)continue;
11                sb.deleteCharAt(sb.length()-1);
12            }else if(ch == '#'){
13                if(sb.length() == 0)continue;
14                sb = new StringBuilder(sb.toString() + sb.toString());
15            }else sb.append(ch);
16        }
17        return sb.toString();
18    }
19}