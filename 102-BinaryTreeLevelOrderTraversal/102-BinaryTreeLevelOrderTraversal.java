// Last updated: 7/9/2026, 5:24:35 PM
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
    public int level(TreeNode root){
        if(root == null) return 0;
        // if(root.left == null&& root.right == null) return 0;
        return 1+Math.max(level(root.left),level(root.right));

    }
    public void allLevels(TreeNode root , List<Integer> list, int n){
        if(root == null) return;
        if(n == 1) {
            list.add(root.val);
            return;
        }
        allLevels(root.left,list,n-1);
        allLevels(root.right,list,n-1);

    }
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ll = new ArrayList<>();
        int level = level(root);
        for(int i = 1 ; i <= level ; i++){
            List<Integer> list = new ArrayList<>();
            allLevels(root,list,i);
            ll.add(list);
        }
        return ll;
    }
}