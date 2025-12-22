// Last updated: 12/22/2025, 11:36:31 PM
1class Solution {
2    public String pushDominoes(String s) {
3        int n = s.length();
4        int[] left = new int[n];
5        int[] right = new int[n];
6        StringBuilder sb = new StringBuilder();
7
8        for(int i = 0 ; i < n ; i++){
9            if(s.charAt(i) == 'R') left[i] = i;
10            else if(s.charAt(i) == 'L') left[i]= -1;
11            else if(i == 0 && s.charAt(i) == '.') left[i] = -1;
12            else{
13                left[i] = left[i-1];
14            }
15        }
16
17        for(int i = n-1 ; i >= 0 ; i--){
18            if(s.charAt(i) == 'L') right[i] = i;
19            else if(s.charAt(i) == 'R') right[i]= -1;
20            else if(i == n-1 && s.charAt(i) == '.') right[i] = -1;
21            else{
22                right[i] = right[i+1];
23            }
24        }
25
26        for(int i = 0 ; i < n ; i++){
27            
28            int leftdiff = Math.abs(i - left[i]);
29            int rightdiff = Math.abs(i - right[i]);
30            if(left[i] == -1 && right[i] == -1) sb.append(".");
31            else if(left[i] == -1){
32                sb.append("L");
33            }
34            else if(right[i] == -1){
35                sb.append("R");
36            }else if(leftdiff < rightdiff){
37                sb.append("R");
38            }else if(leftdiff > rightdiff){
39                sb.append("L");
40            }else if(leftdiff == rightdiff) sb.append(".");
41        }
42        return sb.toString();
43    }
44}