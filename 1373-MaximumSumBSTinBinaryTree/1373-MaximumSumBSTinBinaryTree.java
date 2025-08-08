// Last updated: 8/8/2025, 12:04:49 PM
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
     public BstPair ValidBST(TreeNode root){
        if(root == null) return new BstPair();
        BstPair lbp = ValidBST(root.left);
        BstPair rbp = ValidBST(root.right);
        BstPair sbp = new BstPair();
        sbp.min = Math.min(lbp.min , Math.min(rbp.min , root.val));
        sbp.max = Math.max(lbp.max, Math.max(rbp.max , root.val));
        sbp.sum = lbp.sum + rbp.sum + root.val;
        sbp.isbst = lbp.isbst && rbp.isbst && root.val > lbp.max && root.val < rbp.min;
        if(sbp.isbst){
            sbp.ans = Math.max(lbp.ans , Math.max(rbp.ans , sbp.sum));
        }else{
            sbp.ans = Math.max(lbp.ans,rbp.ans);
        }
        return sbp;
    }
    public int maxSumBST(TreeNode root) {
        return ValidBST(root).ans;
    }

    class BstPair{
        boolean isbst = true;
        long min = Integer.MAX_VALUE;
        long max = Integer.MIN_VALUE;
        int ans = 0;
        int sum = 0 ;
    }
}