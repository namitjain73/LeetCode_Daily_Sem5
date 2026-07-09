// Last updated: 7/9/2026, 5:20:10 PM
class Solution {
    public int[] asteroidCollision(int[] ast) {
        Stack<Integer> st =  new Stack<>();
        for(int i : ast){
            if(i > 0){
                st.push(i);
            }else{
                while(!st.empty() && st.peek() > 0 && st.peek() < -i){
                    st.pop();
                }
                if(st.empty() || st.peek() < 0) st.push(i);
                if(st.peek() == -i) st.pop();
            }
        }

        int[] arr = new int[st.size()];
        int i = st.size()-1;
        while(!st.empty()){
            arr[i--] = st.pop();
        }
        return arr;
    }
}