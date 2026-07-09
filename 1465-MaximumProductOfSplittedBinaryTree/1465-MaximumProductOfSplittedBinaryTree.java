// Last updated: 7/9/2026, 5:16:45 PM
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
    long sum;
    long max;
    int mod = 1_000_000_007;
    public long total_sum(TreeNode root){
        if(root == null) return 0;
        return total_sum(root.left) + total_sum(root.right) + root.val;
    }
    public int maxProduct(TreeNode root) {
        sum = total_sum(root);
        max = 0;
        solver(root);
        return (int)(max%mod);
    }
    public long solver(TreeNode root){
        if(root == null) return 0;


        long left = solver(root.left);
        long right = solver(root.right);
        long root_sum = left+ right + root.val;
        max = Math.max(max,root_sum * (sum - root_sum));
        return root_sum;
    }
}