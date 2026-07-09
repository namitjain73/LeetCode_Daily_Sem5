// Last updated: 7/9/2026, 5:24:12 PM
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
    public int maxPathSum(TreeNode root) {
        Pair p =max(root);
        return (int)p.ans;
    }

    public Pair max(TreeNode root){
        if(root == null) return new Pair();

        Pair lbp = max(root.left);
        Pair rbp = max(root.right);
        Pair sbp = new Pair();
        sbp.sum = Math.max(0,Math.max(lbp.sum, rbp.sum)) + root.val;
        long p = root.val + Math.max(0,lbp.sum) + Math.max(0,rbp.sum);
        sbp.ans = Math.max(lbp.ans,Math.max(rbp.ans,p));
        return sbp;
    }
    class Pair{
        long sum = 0;
        long ans = Integer.MIN_VALUE;
    }
}