// Last updated: 8/12/2025, 11:40:07 PM
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
};
*/

class Solution {
    public int helper(Node root){
        if(root == null) return 0;
        int n = 1;

        for(int i = 0 ; i < root.children.size() ; i++){
            n = Math.max(n,helper(root.children.get(i))+1);
        }
        return n;
    }
    public int maxDepth(Node root) {
        return helper(root);
    }
}