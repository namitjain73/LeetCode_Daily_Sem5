// Last updated: 7/9/2026, 5:24:22 PM
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
    int sum = Integer.MAX_VALUE;
    public int depth(TreeNode root,int n){
        if(root == null) return 0;
        if(root.left == null && root.right == null){
            sum = Math.min(sum,n);
            
        }
        depth(root.left,n+1);
        depth(root.right,n+1);
        return n;
    }
    public int minDepth(TreeNode root) {
        if(root == null)return 0;
        depth(root,1);
        return sum;
    }
}