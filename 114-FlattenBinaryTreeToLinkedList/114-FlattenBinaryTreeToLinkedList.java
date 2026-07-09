// Last updated: 7/9/2026, 5:24:18 PM
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
    public void flatten(TreeNode root) {
        if(root == null)return;
        TreeNode left = root.left;
        TreeNode right = root.right;
        root.left = null;
        flatten(left);
        flatten(right);
        TreeNode temp = left;
        root.right = left;
        while(temp != null && temp.right != null){
            temp = temp.right;
        }
        if(temp != null){
            temp.right = right;
        }else{
            root.right = right;
        }
        return;
    }
}