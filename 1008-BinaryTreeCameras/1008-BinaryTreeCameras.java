// Last updated: 7/9/2026, 5:18:32 PM
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
    int ans;
    public int minCameraCover(TreeNode root) {
        ans = 0;
        if(solver(root) == -1) ans++;
        return ans;
    }
    public int solver(TreeNode root){
        if(root == null) return 0;


        int left = solver(root.left);
        int right = solver(root.right);
        if(left == -1 || right == -1) {
            ans++;
            return 1;
        }else if(left == 1 || right == 1) return 0;
        else return -1;
    }
}