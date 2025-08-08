// Last updated: 8/8/2025, 11:02:19 AM
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
        sbp.max = Math.max(lbp.max , Math.max(rbp.max , root.val));
        // sbp.sum = lbp+rbp.root.val;
        sbp.isbst = lbp.isbst && rbp.isbst && lbp.max< root.val && rbp.min  > root.val;
        // if(sbp.isbst){
        //     sbp.ans = Math.max(lbp.ans , Math.max(rbp.ans , sbp.sum));
        // }else{
        //     sbp.ans = Math.max(lbp.ans , rbp.sum);
        // }
        return sbp;
    }
    public boolean isValidBST(TreeNode root) {
        return ValidBST(root).isbst;
    }

    class BstPair{
        boolean isbst = true;
        long max = Long.MIN_VALUE;
        long min = Long.MAX_VALUE;
        int sum = 0;
        int ans = 0; //only max of bst part sum
    }
}