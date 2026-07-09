// Last updated: 7/9/2026, 5:17:55 PM
class Solution {
    public String removeDuplicates(String s) {
        Stack<Character> st= new Stack<>();
        int n = s.length();

        for(int i = 0 ; i < n ; i++){
            if(!st.isEmpty() && st.peek() == s.charAt(i)) st.pop();
            else st.push(s.charAt(i));
        }
        // System.out.println(st);
        StringBuilder sb = new StringBuilder();
        while(!st.isEmpty()){
            sb.append(st.pop());
        }
        return sb.reverse().toString();
    }
}