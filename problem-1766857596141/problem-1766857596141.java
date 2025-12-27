// Last updated: 12/27/2025, 11:16:36 PM
1class Solution {
2    public String resultingString(String s) {
3        StringBuilder sb = new StringBuilder();
4
5        sb.append(s.charAt(0));
6        for(int i = 1 ; i < s.length() ; i++){
7            if(sb.length() == 0){
8                sb.append(s.charAt(i));
9                continue;
10            }
11            char ch1 = sb.charAt(sb.length()-1);
12            char ch2 = s.charAt(i);
13            if( (ch1 == ch2+1) || (ch1+1 == ch2) || (ch1 == 'a' && ch2 == 'z') || (ch1 == 'z' && ch2 == 'a') ){
14                sb.deleteCharAt(sb.length()-1);
15            }else{
16                sb.append(ch2);
17            }
18        }
19        return sb.toString();
20    }
21}