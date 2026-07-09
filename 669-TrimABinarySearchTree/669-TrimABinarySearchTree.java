// Last updated: 7/9/2026, 5:20:31 PM
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
    public void helper(TreeNode root , int low , int hi){
        if(root == null) return;

        while(root.left != null){
            if(root.left.val < low) root.left = root.left.right;
            else if(root.left.val > hi) root.left = root.left.left;
            else break;
        }
        while(root.right != null){
            if(root.right.val < low) root.right= root.right.right;
            else if(root.right.val > hi) root.right = root.right.left;
            else break;
        }
        helper(root.left,low,hi);
        helper(root.right,low,hi);
    }
    public TreeNode trimBST(TreeNode root, int low, int high) {
        TreeNode dummy = new TreeNode(0);
        dummy.left = root;
        helper(dummy,low,high);
        return dummy.left;
    }
}