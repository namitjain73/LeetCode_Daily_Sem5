// Last updated: 7/9/2026, 5:22:55 PM
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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if((p.val < root.val && q.val > root.val) || (q.val < root.val && p.val > root.val)) return root;

        if(p.val < root.val && q.val < root.val) return lowestCommonAncestor(root.left,p,q);
        else if(p.val > root.val && q.val > root.val) return lowestCommonAncestor(root.right,p,q);
        return root;
    }
}