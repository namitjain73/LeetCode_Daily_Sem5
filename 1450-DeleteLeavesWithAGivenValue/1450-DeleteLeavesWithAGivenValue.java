// Last updated: 7/9/2026, 5:16:49 PM
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
    public TreeNode removeLeafNodes(TreeNode root, int t) {
        TreeNode temp = new TreeNode(0);
        temp.left = root;
        solver(temp , t);
        return temp.left;
    }

    public void solver(TreeNode root , int t){
        if(root == null) return;
        if(root.left == null && root.right == null) return;

        solver(root.left,t);
        solver(root.right,t);
        if(root.left != null && root.left.left == null && root.left.right == null && root.left.val == t){
            root.left = null;
        }
        if(root.right != null && root.right.left == null && root.right.right == null && root.right.val == t){
            root.right = null;
        }
    }
}