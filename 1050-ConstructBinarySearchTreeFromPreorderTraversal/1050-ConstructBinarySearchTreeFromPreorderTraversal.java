// Last updated: 7/9/2026, 5:18:17 PM
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
    public void helper(TreeNode root , int val){
        if(root == null) return;

        if(val < root.val){
            if(root.left == null) root.left = new TreeNode(val);
            else helper(root.left,val);
        }
        else{
            if(root.right == null) root.right = new TreeNode(val);
            else helper(root.right,val);
        }
    }
    public TreeNode bstFromPreorder(int[] preorder) {
        TreeNode root = new TreeNode(preorder[0]);
        for(int i = 1 ; i < preorder.length ; i++){
            helper(root,preorder[i]);
        }
        return root;
    }
}