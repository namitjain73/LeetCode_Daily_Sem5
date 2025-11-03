// Last updated: 11/3/2025, 3:23:57 PM
class Solution {
    public int calculate(String s) {
        Stack<Integer> st = new Stack<>();
        char sgn = '+';
        long n = 0;
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                n = n * 10 + (c - '0');
            }
            if ((!Character.isDigit(c) && !Character.isWhitespace(c)) || i == s.length() - 1) {
                if (sgn == '+') st.push((int)n);
                else if (sgn == '-') st.push((int)(-n));
                else if (sgn == '*') st.push(st.pop() * (int)n);
                else if (sgn == '/') st.push(st.pop() / (int)n);
                
                sgn = c;
                n = 0;
            }
        }
        
        int res = 0;
        while (!st.isEmpty()) {
            res += st.pop();
        }
        return res;
    }
}