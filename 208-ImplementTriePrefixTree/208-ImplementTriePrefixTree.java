// Last updated: 7/9/2026, 5:23:19 PM

public class Trie {
	
	class Node{
		char ch;
		boolean isterminal;
		HashMap<Character,Node> child;
		public Node(char ch) {
			this.ch= ch;
			child = new HashMap<>();
			}
	}
	
	private Node root;
	
	public Trie() {
		// TODO Auto-generated constructor stub
		Node nn = new Node('*');
		//nn.ch = '*';
		root = nn;
	}

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
        	//if(i == word.length()-1) curr.isterminal = true;
        }
        curr.isterminal = true;
    }
    
    public boolean search(String word) {
    	Node curr = root;
        for(int i = 0 ; i < word.length() ; i++) {
        	char ch = word.charAt(i);
        	if(curr.child.containsKey(ch)) {
        		curr = curr.child.get(ch);
        	}else return false;
        }
        return curr.isterminal;
    }
//    
    public boolean startsWith(String prefix) {
        Node curr = root;
        for(int i = 0 ; i < prefix.length() ; i++) {
        	char ch = prefix.charAt(i);
        	if(curr.child.containsKey(ch)) {
        		curr = curr.child.get(ch);
        	}else return false;
        }
        return true;
    }

}
