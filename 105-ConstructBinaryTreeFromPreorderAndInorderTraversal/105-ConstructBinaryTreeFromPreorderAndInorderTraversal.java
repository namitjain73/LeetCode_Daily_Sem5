// Last updated: 7/9/2026, 5:24:30 PM
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
    public TreeNode helper(int[] pre , int prelo , int prehi , int[] in , int inlo , int inhi){
        if(prelo > prehi || inlo > inhi) return null;
        TreeNode root = new TreeNode(pre[prelo]);
        int i = inlo;
        while(pre[prelo] != in[i]) i++;
        int leftsize = i - inlo;
        root.left = helper(pre , prelo+1 , prelo + leftsize , in , inlo , i - 1);
        root.right = helper(pre , leftsize + prelo + 1, prehi , in , i+1 , inhi);
        return root;
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = inorder.length;
        return helper(preorder,0,n-1,inorder,0,n-1);
    }
}