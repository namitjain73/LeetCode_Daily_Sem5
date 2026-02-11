// Last updated: 2/11/2026, 12:46:49 PM
1class Solution {
2    static class Trie{
3		class Node{
4			Node zero;
5			Node one;
6		}
7		private Node root= new Node();
8		public void add(int val) {
9			Node curr = root;
10			for(int i = 31 ; i >= 0 ; i--) {
11				int bit = val & (1 << i);
12				if(bit == 0) {
13					if(curr.zero != null) {
14						curr = curr.zero;
15					}else {
16					Node nn= new Node();
17					curr.zero = nn;
18					curr = nn;
19					}
20				}else {
21					if(curr.one != null) {
22						curr = curr.one;
23					}else {
24					Node nn= new Node();
25					curr.one = nn;
26					curr = nn;
27					}
28				}
29			}
30        }
31		public int getMaxXor(int x) {
32			int ans = 0 ;
33			Node curr = root;
34			for(int i = 31 ; i >= 0 ; i--) {
35				int bit = x & (1 << i);
36				if(bit == 0) {
37					if(curr.one != null) {
38						ans = ans | (1 << i);
39						curr = curr.one;
40					}else {
41						curr = curr.zero;
42					}
43				}else {
44					if(curr.zero != null) {
45						ans = ans | (1 << i);
46						curr = curr.zero;
47					}else {
48						curr = curr.one;
49					}
50					
51				}
52			}
53			
54			return ans;
55        }
56    }
57
58
59    public int findMaximumXOR(int[] arr) {
60		Trie t = new Trie();
61        int ans = 0;
62        for(int x : arr){
63            t.add(x);
64        }
65		for(int x : arr) {
66			ans = Math.max(t.getMaxXor(x), ans);
67		}
68        return ans;
69	}
70}