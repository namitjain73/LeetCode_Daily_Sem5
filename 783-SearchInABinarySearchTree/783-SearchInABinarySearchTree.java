// Last updated: 7/9/2026, 5:19:49 PM
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
    public TreeNode searchBST(TreeNode root, int val) {
        if(root == null) return null;
        if(root.val == val) return root;
        TreeNode left = null;
        TreeNode right = null;
        if(root.val > val) {
            left = searchBST(root.left,val);;
        }
        else {
            right = searchBST(root.right,val);
        }
        if(left != null) return left;
        return right;
    }
}