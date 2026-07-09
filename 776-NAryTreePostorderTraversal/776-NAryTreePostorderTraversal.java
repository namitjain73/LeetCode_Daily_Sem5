// Last updated: 7/9/2026, 5:19:50 PM
/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}
*/

class Solution {
    public void helper(Node root , List<Integer> list){
        if(root == null) return;
        for(Node n:root.children){
            helper(n,list);
        }
        list.add(root.val);
    }
    public List<Integer> postorder(Node root) {
        List<Integer> list = new ArrayList<>();
        helper(root,list);
        return list;
    }
}