// Last updated: 1/9/2026, 4:41:16 PM
1class Solution {
2    public String reverseStr(String s, int k) {
3        StringBuilder sb = new StringBuilder();
4        boolean f= true;
5        for(int i = 0 ; i <= s.length() ; i += k){
6            if(i+k >= s.length()){
7                if(f){
8                    StringBuilder sb2= new StringBuilder(s.substring(i));
9                    sb.append(sb2.reverse().toString());
10                }else{
11                    sb.append(s.substring(i));
12                }
13            }else if(f){
14                StringBuilder sb2= new StringBuilder(s.substring(i,i+k));
15                sb.append(sb2.reverse().toString());
16                f = false;
17            }else{
18                sb.append(s.substring(i, i+k));
19                f = true;
20            }
21        }
22        return sb.toString();
23    }
24}