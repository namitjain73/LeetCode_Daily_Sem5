// Last updated: 2/5/2026, 12:59:58 PM
1class Solution {
2
3    static ArrayList<String> ll;
4	static class Trie{
5		class Node{
6			char ch;
7			String isterminal;
8			HashMap<Character,Node> child;
9			public Node(char ch) {
10				this.ch = ch;
11				child = new HashMap<>();
12			}
13		}
14		
15		Node root = new Node('*');
16		
17		public void insert(String word) {
18			Node curr = root;
19			for(int i = 0 ; i < word.length(); i++) {
20				char ch = word.charAt(i);
21				if(curr.child.containsKey(ch)) {
22					curr = curr.child.get(ch);
23				}else {
24					Node nn = new Node(ch);
25					curr.child.put(ch, nn);
26					curr = nn;
27				}
28			}
29			curr.isterminal = word;
30			
31		}
32		private static void search(char[][] maze, int i, int j, Node node) {
33			// TODO Auto-generated method stub
34			if(i < 0 || j < 0 || i >= maze.length || j >= maze[0].length || !node.child.containsKey(maze[i][j])) return;
35			
36			char ch = maze[i][j];
37			node = node.child.get(ch);
38			if(node.isterminal != null) {
39				ll.add(node.isterminal);
40				node.isterminal = null;
41			}
42			
43			
44			
45			maze[i][j] = '*';
46			
47			int[] a = {1,-1,0,0};
48			int[] b = {0,0,1,-1};
49			for(int k = 0 ; k < 4 ; k++) {
50				search(maze , i+a[k] , j + b[k] , node);
51			}
52			maze[i][j] = ch;
53		}
54	}
55	
56    public List<String> findWords(char[][] maze, String[] words) {
57		ll = new ArrayList<>();
58		Trie t = new Trie();
59		for(String s : words) {
60			t.insert(s);
61		}
62		int n = maze.length;
63		int m =  maze[0].length;
64		
65		
66		for(int i =  0 ; i < n;  i++) {
67			for(int j = 0 ; j < m ; j++) {
68				if(t.root.child.containsKey(maze[i][j])) {
69					t.search(maze,i,j,t.root);
70				}
71			}
72		}
73        return ll;
74    }
75
76    
77}