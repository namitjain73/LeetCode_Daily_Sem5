// Last updated: 7/9/2026, 5:21:03 PM
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
    public void inorder(TreeNode root , List<Integer> ll){
        if(root == null) return ;

        inorder(root.left,ll);
        ll.add(root.val);
        inorder(root.right,ll);
    }
    public int getMinimumDifference(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        inorder(root,list);
        int min = Integer.MAX_VALUE;
        for(int i = 1; i < list.size() ; i++){
            min = Math.min(list.get(i) - list.get(i-1),min);
            if(min == 0) return 0;
        }
        return min;
    }
}









