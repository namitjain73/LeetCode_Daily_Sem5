// Last updated: 7/9/2026, 5:18:07 PM
class Solution {
    public String removeOuterParentheses(String s) {
        String ans= "";
        int c = 0;

        Stack<Character> st = new Stack<>();
        int n = s.length();
        for(int i = 0 ; i < n ; i++){
            if(s.charAt(i) == '(') c++;
            else if(s.charAt(i) == ')') c--;
            st.push(s.charAt(i));
            if(c == 0){
                StringBuilder sb = new StringBuilder();
                st.pop();
                while(st.size() != 1){
                    sb.append(st.pop());
                }
                st.pop();
                ans += sb.reverse().toString();
            }
        }
        return ans;
    }
}