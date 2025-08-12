// Last updated: 8/13/2025, 12:48:01 AM
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
    int n = 0;
    public int helper(TreeNode root){
        if(root == null) return 0;


        int left = helper(root.left);
        int right = helper(root.right);
        n += Math.abs(left - right);
        return root.val + left + right;
    }
    public int findTilt(TreeNode root) {
        n = 0;
        helper(root);
        return n;
    }
}