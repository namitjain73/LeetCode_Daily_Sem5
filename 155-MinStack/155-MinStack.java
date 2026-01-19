// Last updated: 1/19/2026, 3:34:33 PM
1class MinStack {
2    PriorityQueue<Integer> pq;
3    List<Integer> ll;
4
5    public MinStack() {
6        ll = new ArrayList<>();
7        pq= new PriorityQueue<>();
8    }
9    
10    public void push(int val) {
11        pq.add(val);
12        ll.add(val);
13    }
14    
15    public void pop() {
16        ll.remove(ll.size()-1);
17    }
18    
19    public int top() {
20        return ll.get(ll.size()-1);
21    }
22    
23    public int getMin() {
24        while(!ll.contains(pq.peek())) pq.poll();
25        return pq.peek();
26    }
27}
28
29/**
30 * Your MinStack object will be instantiated and called as such:
31 * MinStack obj = new MinStack();
32 * obj.push(val);
33 * obj.pop();
34 * int param_3 = obj.top();
35 * int param_4 = obj.getMin();
36 */