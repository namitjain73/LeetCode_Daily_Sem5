// Last updated: 7/9/2026, 5:24:28 PM
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
    List<List<Integer>> ll;
    public void solver(TreeNode root , int i){
        if(root == null) return;

        if((ll.size()-1) < i) ll.add(new ArrayList());
        ll.get(i).add(root.val);

        solver(root.left,i+1);
        solver(root.right , i+1);
    }
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        ll = new ArrayList<>();
        solver(root , 0);
        Collections.reverse(ll);
        return ll;
    }
}