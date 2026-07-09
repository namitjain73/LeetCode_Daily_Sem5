// Last updated: 7/9/2026, 5:20:37 PM
class Solution {
    static class Trie{
		class Node{
			char ch;
			String isterminal;
	//		boolean isterminal;
			HashMap<Character,Node> child;
			public Node(char ch) {
				this.ch = ch;
				child = new HashMap<>();
			}
		}
		
		private Node root = new Node('*');
		
		public void insert(String word) {
			Node curr = root;
			for(int i = 0 ; i <word.length() ; i++) {
				char ch = word.charAt(i);
				if(curr.child.containsKey(ch)) {
					curr = curr.child.get(ch);
				}else {
					Node nn = new Node(ch);
					curr.child.put(ch, nn);
					curr= nn;
				}
			}
			curr.isterminal = word;
			
		}
		
		public String search(String word) {
			Node curr = root;
			for(int i = 0 ; i < word.length(); i++) {
				char ch = word.charAt(i);
				if(curr.child.containsKey(ch)) {
					curr= curr.child.get(ch);
					if(curr.isterminal != null) return curr.isterminal;
				}else {
					return word;
				}
			}
			return word;
		}
	}
    public String replaceWords(List<String> dict, String sentence) {
		 Trie t = new Trie();
		 for(String i : dict) {
			 t.insert(i);
		 }
		 
		 
		 String[] arr = sentence.split(" ");
		 StringBuilder sb = new StringBuilder();
		 for(int i = 0 ; i < arr.length ; i++) {
			String get = t.search(arr[i]);
			sb.append(get);
            if(i < arr.length-1) sb.append(" ");
		 }
		 return sb.toString();
    }
}