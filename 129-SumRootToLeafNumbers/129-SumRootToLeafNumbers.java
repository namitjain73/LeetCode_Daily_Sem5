// Last updated: 7/9/2026, 5:24:08 PM
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
    int ans = 0;
    public int sumNumbers(TreeNode root) {
        ans = 0;
        return solver(root , 0);
    }
    public int solver(TreeNode root , int res){
        if(root == null){
            return 0;
        }
        if(root.left == null && root.right == null){
            return res*10+root.val;
        }

        int n = solver(root.left , res*10+root.val);
        int m = solver(root.right, res*10+root.val);
        return n + m;
    }
}