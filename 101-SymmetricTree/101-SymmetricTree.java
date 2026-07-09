// Last updated: 7/9/2026, 5:24:36 PM
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean solver(TreeNode p , TreeNode q){
        if(p == null && q == null) return true;
        if(p== null || q == null) return false;

        boolean left = solver(p.left , q.right);
        boolean right = solver(p.right , q.left);
        return left && right && p.val == q.val;
    }
    public boolean isSymmetric(TreeNode root) {
        return solver(root.left , root.right);
    }
}