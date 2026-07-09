// Last updated: 7/9/2026, 5:24:26 PM
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
    public TreeNode tree(int[] num , int lo , int hi){
        if(lo > hi) return null;
        if(hi == lo){
            return new TreeNode(num[lo]);
        }

        int mid = (lo + hi) / 2;
        TreeNode temp = new TreeNode(num[mid]);
        temp.left = tree(num,lo,mid-1);
        temp.right = tree(num,mid+1,hi);
        return temp;
    }
    public TreeNode sortedArrayToBST(int[] nums) {
        return tree(nums,0,nums.length-1);
        
    }
}