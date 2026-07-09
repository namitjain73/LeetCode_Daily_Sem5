// Last updated: 7/9/2026, 5:25:56 PM
class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        Map<Character,Character> map= new HashMap<>();
        map.put(']' , '[');
        map.put('}' , '{');
        map.put(')' , '(');


        for(char c : s.toCharArray()){
            if (map.containsKey(c)) {
                if(!st.empty() && st.peek() == map.get(c)){
                    st.pop();
                }
                else return false;

            }
            else{
                st.push(c);
            }
        }

        return st.empty();
    }
}