// Last updated: 8/22/2025, 12:07:43 AM
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

    public int helper(TreeNode root){
        if(root == null) return 0;

        int left = helper(root.left);
        int right = helper(root.right);

        ans += Math.abs(left) + Math.abs(right);
        return root.val + left + right - 1;
    }
    public int distributeCoins(TreeNode root) {
        ans = 0;
        helper(root);
        return ans;
    }
}