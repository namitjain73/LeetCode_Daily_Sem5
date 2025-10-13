// Last updated: 10/14/2025, 12:35:19 AM
class StockSpanner {
List<Integer> ll;
Stack<Integer> st;
    public StockSpanner() {
        ll = new ArrayList<>();
        st = new Stack<>();
    }
    
    public int next(int price) {
        int ans = 1;
        while(!st.isEmpty() && ll.get(st.peek()) <= price){
		    st.pop();
		}
		ans = st.isEmpty() ? ll.size()+1 : (ll.size()) - st.peek();
		st.push(ll.size());
        ll.add(price);
        return ans;
        
    }
}