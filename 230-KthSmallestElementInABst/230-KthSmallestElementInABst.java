// Last updated: 7/9/2026, 5:23:00 PM
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
    int temp = -1;
    int n = 0;
    public void Inorder(TreeNode root){
        if(root == null) return;

        Inorder(root.left);
        n--;
        if(n == 0){
            temp = root.val;
            return;
        }
        Inorder(root.right);
    }
    public int kthSmallest(TreeNode root, int k) {
        n = k;
        Inorder(root);
        return temp;
    }
}