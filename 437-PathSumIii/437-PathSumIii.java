// Last updated: 7/9/2026, 5:21:38 PM
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
    public int allpaths(TreeNode root , long t){
        if(root == null) return 0;
        int count = 0;
        if(t == (int)(root.val)){
            count++;
        }

        count += allpaths(root.left,t-(int)(root.val)) + allpaths(root.right,t-(int)(root.val));
        return count;
    }
    public int pathSum(TreeNode root, int t) {
        if(root == null) return 0;
        int count = allpaths(root,(long)t);
        count += pathSum(root.left,t) + pathSum(root.right,t);
        return count;
    }
}