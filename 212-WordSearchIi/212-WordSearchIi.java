// Last updated: 7/9/2026, 5:23:18 PM
class Solution {

    static ArrayList<String> ll;
	static class Trie{
		class Node{
			char ch;
			String isterminal;
			HashMap<Character,Node> child;
			public Node(char ch) {
				this.ch = ch;
				child = new HashMap<>();
			}
		}
		
		Node root = new Node('*');
		
		public void insert(String word) {
			Node curr = root;
			for(int i = 0 ; i < word.length(); i++) {
				char ch = word.charAt(i);
				if(curr.child.containsKey(ch)) {
					curr = curr.child.get(ch);
				}else {
					Node nn = new Node(ch);
					curr.child.put(ch, nn);
					curr = nn;
				}
			}
			curr.isterminal = word;
			
		}
		private static void search(char[][] maze, int i, int j, Node node) {
			// TODO Auto-generated method stub
			if(i < 0 || j < 0 || i >= maze.length || j >= maze[0].length || !node.child.containsKey(maze[i][j])) return;
			
			char ch = maze[i][j];
			node = node.child.get(ch);
			if(node.isterminal != null) {
				ll.add(node.isterminal);
				node.isterminal = null;
			}
			
			
			
			maze[i][j] = '*';
			
			int[] a = {1,-1,0,0};
			int[] b = {0,0,1,-1};
			for(int k = 0 ; k < 4 ; k++) {
				search(maze , i+a[k] , j + b[k] , node);
			}
			maze[i][j] = ch;
		}
	}
	
    public List<String> findWords(char[][] maze, String[] words) {
		ll = new ArrayList<>();
		Trie t = new Trie();
		for(String s : words) {
			t.insert(s);
		}
		int n = maze.length;
		int m =  maze[0].length;
		
		
		for(int i =  0 ; i < n;  i++) {
			for(int j = 0 ; j < m ; j++) {
				if(t.root.child.containsKey(maze[i][j])) {
					t.search(maze,i,j,t.root);
				}
			}
		}
        return ll;
    }

    
}