// Last updated: 2/11/2026, 12:20:07 PM
1class Solution {
2    public String maxValue(String s, int x) {
3        StringBuilder sb = new StringBuilder();
4        int n = s.length();
5        boolean f = true;
6        if(s.charAt(0) == '-') for(int i = 0 ; i <n ; i++){
7            char ch = s.charAt(i);
8            if(ch == '-') sb.append(ch);
9            else{
10                if(ch-'0' > x && f){
11                    sb.append(x);
12                    f = false;
13                    
14                }
15                sb.append(ch);
16            }
17            if(i == n-1 && f){
18                sb.append(x);
19            }
20        }
21
22        else{
23            for(int i = 0 ; i <n ; i++){
24                char ch = s.charAt(i);
25                if(ch-'0' < x && f){
26                    sb.append(x);
27                    f = false;
28                    
29                }
30                sb.append(ch);
31                if(i == n-1 && f){
32                    sb.append(x);
33                }
34            }
35        }
36        
37        return sb.toString();
38    }
39}