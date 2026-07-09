// Last updated: 7/9/2026, 5:21:43 PM
class Solution {
    static class Trie{
		class Node{
			Node zero;
			Node one;
		}
		private Node root= new Node();
		public void add(int val) {
			Node curr = root;
			for(int i = 31 ; i >= 0 ; i--) {
				int bit = val & (1 << i);
				if(bit == 0) {
					if(curr.zero != null) {
						curr = curr.zero;
					}else {
					Node nn= new Node();
					curr.zero = nn;
					curr = nn;
					}
				}else {
					if(curr.one != null) {
						curr = curr.one;
					}else {
					Node nn= new Node();
					curr.one = nn;
					curr = nn;
					}
				}
			}
        }
		public int getMaxXor(int x) {
			int ans = 0 ;
			Node curr = root;
			for(int i = 31 ; i >= 0 ; i--) {
				int bit = x & (1 << i);
				if(bit == 0) {
					if(curr.one != null) {
						ans = ans | (1 << i);
						curr = curr.one;
					}else {
						curr = curr.zero;
					}
				}else {
					if(curr.zero != null) {
						ans = ans | (1 << i);
						curr = curr.zero;
					}else {
						curr = curr.one;
					}
					
				}
			}
			
			return ans;
        }
    }


    public int findMaximumXOR(int[] arr) {
		Trie t = new Trie();
        int ans = 0;
        for(int x : arr){
            t.add(x);
        }
		for(int x : arr) {
			ans = Math.max(t.getMaxXor(x), ans);
		}
        return ans;
	}
}