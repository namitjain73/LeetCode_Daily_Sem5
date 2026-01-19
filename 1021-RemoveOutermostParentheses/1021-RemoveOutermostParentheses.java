// Last updated: 1/19/2026, 2:54:16 PM
1class Solution {
2    public String removeOuterParentheses(String s) {
3        String ans= "";
4        int c = 0;
5
6        Stack<Character> st = new Stack<>();
7        int n = s.length();
8        for(int i = 0 ; i < n ; i++){
9            if(s.charAt(i) == '(') c++;
10            else if(s.charAt(i) == ')') c--;
11            st.push(s.charAt(i));
12            if(c == 0){
13                StringBuilder sb = new StringBuilder();
14                st.pop();
15                while(st.size() != 1){
16                    sb.append(st.pop());
17                }
18                st.pop();
19                ans += sb.reverse().toString();
20            }
21        }
22        return ans;
23    }
24}