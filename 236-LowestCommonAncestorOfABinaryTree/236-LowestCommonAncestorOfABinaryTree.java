// Last updated: 7/9/2026, 5:22:53 PM
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean check(TreeNode root , TreeNode t){
        if(root == null) return false;
        if(root == t) return true;
        return check(root.left,t) || check(root.right , t);
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(p == q) return p;
        if(root == p || root == q ) return root;
        boolean left = check(root.left,p);
        boolean right = check(root.right , q);
        if( (left && right ) || (!left && !right )) return root;
        if(left && !right) return lowestCommonAncestor(root.left , p, q);
        if( !left && right ) return lowestCommonAncestor(root.right , p,q);
        return root;
    }
}