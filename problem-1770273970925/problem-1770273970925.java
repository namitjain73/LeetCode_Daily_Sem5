// Last updated: 2/5/2026, 12:16:10 PM
1class Solution {
2    static class Trie{
3		class Node{
4			char ch;
5			String isterminal;
6	//		boolean isterminal;
7			HashMap<Character,Node> child;
8			public Node(char ch) {
9				this.ch = ch;
10				child = new HashMap<>();
11			}
12		}
13		
14		private Node root = new Node('*');
15		
16		public void insert(String word) {
17			Node curr = root;
18			for(int i = 0 ; i <word.length() ; i++) {
19				char ch = word.charAt(i);
20				if(curr.child.containsKey(ch)) {
21					curr = curr.child.get(ch);
22				}else {
23					Node nn = new Node(ch);
24					curr.child.put(ch, nn);
25					curr= nn;
26				}
27			}
28			curr.isterminal = word;
29			
30		}
31		
32		public String search(String word) {
33			Node curr = root;
34			for(int i = 0 ; i < word.length(); i++) {
35				char ch = word.charAt(i);
36				if(curr.child.containsKey(ch)) {
37					curr= curr.child.get(ch);
38					if(curr.isterminal != null) return curr.isterminal;
39				}else {
40					return word;
41				}
42			}
43			return word;
44		}
45	}
46    public String replaceWords(List<String> dict, String sentence) {
47		 Trie t = new Trie();
48		 for(String i : dict) {
49			 t.insert(i);
50		 }
51		 
52		 
53		 String[] arr = sentence.split(" ");
54		 StringBuilder sb = new StringBuilder();
55		 for(int i = 0 ; i < arr.length ; i++) {
56			String get = t.search(arr[i]);
57			sb.append(get);
58            if(i < arr.length-1) sb.append(" ");
59		 }
60		 return sb.toString();
61    }
62}