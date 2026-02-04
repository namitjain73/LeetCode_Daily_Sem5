// Last updated: 2/4/2026, 12:31:11 PM
1
2public class Trie {
3	
4	class Node{
5		char ch;
6		boolean isterminal;
7		HashMap<Character,Node> child;
8		public Node(char ch) {
9			this.ch= ch;
10			child = new HashMap<>();
11			}
12	}
13	
14	private Node root;
15	
16	public Trie() {
17		// TODO Auto-generated constructor stub
18		Node nn = new Node('*');
19		//nn.ch = '*';
20		root = nn;
21	}
22
23	public void insert(String word) {
24        Node curr = root;
25        for(int i = 0 ; i < word.length(); i++) {
26        	char ch = word.charAt(i);
27        	if(curr.child.containsKey(ch)) {
28        		curr = curr.child.get(ch);
29        	}else {
30        		Node nn = new Node(ch);
31        		curr.child.put(ch, nn);
32        		curr = nn;
33        	}
34        	//if(i == word.length()-1) curr.isterminal = true;
35        }
36        curr.isterminal = true;
37    }
38    
39    public boolean search(String word) {
40    	Node curr = root;
41        for(int i = 0 ; i < word.length() ; i++) {
42        	char ch = word.charAt(i);
43        	if(curr.child.containsKey(ch)) {
44        		curr = curr.child.get(ch);
45        	}else return false;
46        }
47        return curr.isterminal;
48    }
49//    
50    public boolean startsWith(String prefix) {
51        Node curr = root;
52        for(int i = 0 ; i < prefix.length() ; i++) {
53        	char ch = prefix.charAt(i);
54        	if(curr.child.containsKey(ch)) {
55        		curr = curr.child.get(ch);
56        	}else return false;
57        }
58        return true;
59    }
60
61}
62