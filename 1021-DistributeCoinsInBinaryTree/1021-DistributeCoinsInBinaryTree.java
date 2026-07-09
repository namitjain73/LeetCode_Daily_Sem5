// Last updated: 7/9/2026, 5:18:27 PM
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
    public int distributeCoins(TreeNode root) {
        ans = 0;
        solver(root);
        return ans;
    }
    public int solver(TreeNode root){
        if(root == null) return 0;
        int left = solver(root.left);
        int right = solver(root.right);
        ans += Math.abs(right)+Math.abs(left);
        return root.val+left+right-1;
    }
}