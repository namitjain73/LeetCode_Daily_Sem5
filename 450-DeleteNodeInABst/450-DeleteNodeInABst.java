// Last updated: 7/9/2026, 5:21:31 PM
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
    public TreeNode deleteNode(TreeNode root, int key) {
        TreeNode temp = new TreeNode(Integer.MAX_VALUE);
        temp.left = root;
        delete(temp,key);
        return temp.left;
    }
    public void delete(TreeNode root , int t){
        if(root == null) return;
        // if(root.left == null || root.right == null) return;
        if(root.val > t){
            if(root.left == null) return;
            if(root.left.val == t){
                if(root.left.left == null && root.left.right == null) root.left = null;
                else if(root.left.left == null || root.left.right == null){
                    if(root.left.left != null) root.left = root.left.left;
                    else root.left = root.left.right;
                }
                else{
                    TreeNode curr = root.left;
                    TreeNode pred = root.left.left;
                    while(pred.right != null) pred = pred.right;
                    delete(root,pred.val);
                    pred.left = curr.left;
                    pred.right = curr.right;
                    root.left = pred;
                }
            }
            else delete(root.left,t);
        }
        else{
            if(root.right == null) return;
             if(root.right.val == t){
                if(root.right.left == null && root.right.right == null) root.right = null;
                else if(root.right.left == null || root.right.right == null){
                    if(root.right.left != null) root.right = root.right.left;
                    else root.right = root.right.right;
                }
                else{
                    TreeNode curr = root.right;
                    TreeNode pred = curr.left;
                    while(pred.right != null) pred = pred.right;
                    delete(root,pred.val);
                    pred.left = curr.left;
                    pred.right = curr.right;
                    root.right = pred;
                }
            }
            else  delete(root.right,t);
        }
    }
}