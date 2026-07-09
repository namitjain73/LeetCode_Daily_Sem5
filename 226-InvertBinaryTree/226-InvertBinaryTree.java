// Last updated: 7/9/2026, 5:23:06 PM
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
    public TreeNode invertTree(TreeNode root) {
        if(root == null) return null;
        TreeNode node = new TreeNode(root.val);
        node.left = invertTree(root.right);
        node.right = invertTree(root.left);
        return  node;        
    }
    // public TreeNode copy(TreeNode root , TreeNode node){
    //     if(root == null) return null;

    // }
}