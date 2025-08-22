// Last updated: 8/22/2025, 3:16:07 PM
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
    int max_depth;
    public List<Integer> rightSideView(TreeNode root) {
        max_depth = 0;
        List<Integer> ll = new ArrayList<>();
        helper(ll,1,root);
        return ll;
    }

    public void helper(List<Integer> list , int curr_node , TreeNode root){
        if(root == null) return;

        if(max_depth < curr_node){
            max_depth = curr_node;
            list.add(root.val);
        }

        helper(list , curr_node+1 , root.right);
        helper(list , curr_node + 1 , root.left);
    }
}