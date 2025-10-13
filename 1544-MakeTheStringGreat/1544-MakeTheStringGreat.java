// Last updated: 10/14/2025, 12:30:33 AM
class Solution {
    public String makeGood(String s) {
        Stack<Character> st = new Stack<>();
        for(int i = 0 ; i < s.length() ; i++){
            if(!st.isEmpty() && ( (st.peek() == (s.charAt(i)-32)) ||( (st.peek()-32 == (s.charAt(i)))))){
                st.pop();
            }else{
                st.push(s.charAt(i));
            }
        }
        StringBuilder sb = new StringBuilder();
        while(!st.isEmpty()){
            sb.append(st.pop());
        }
        return sb.reverse().toString();
    }
}