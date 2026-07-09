// Last updated: 7/9/2026, 5:24:29 PM
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
    public TreeNode helper(int[] post , int postlo , int posthi , int[] in , int inlo , int  inhi){
        if(postlo > posthi || inlo > inhi) return null;
        TreeNode root = new TreeNode(post[posthi]);
        int i = inlo;
        while(post[posthi] != in[i]) i++;
        int leftsize = Math.abs(i - inlo);
        root.left = helper(post ,postlo ,postlo + leftsize -1, in , inlo,i-1 );
        root.right = helper(post , postlo + leftsize , posthi - 1, in ,i+1 , inhi);
        return root;

    }
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int n = inorder.length;
        return helper(postorder,0,n-1,inorder,0,n-1);
    }
}