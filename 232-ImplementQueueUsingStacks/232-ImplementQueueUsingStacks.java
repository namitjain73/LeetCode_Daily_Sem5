// Last updated: 7/9/2026, 5:22:57 PM
class MyQueue {
    Stack<Integer> st = new Stack<>();
    

    public MyQueue() {
        
    }
    
    public void push(int x) {
        ArrayList<Integer> temp = new ArrayList<>();
        while (!st.isEmpty()) {
            temp.add(st.pop());
        }
        st.push(x);
        for (int i = temp.size() - 1; i >= 0; i--) {
            st.push(temp.get(i));
        }

    }
    
    public int pop() {
        return st.pop();
    }
    
    public int peek() {
        return st.peek();
    }
    
    public boolean empty() {
        return st.empty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */