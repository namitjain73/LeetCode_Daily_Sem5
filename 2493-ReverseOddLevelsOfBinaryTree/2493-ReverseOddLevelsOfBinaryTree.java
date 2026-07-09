// Last updated: 7/9/2026, 5:09:46 PM
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
        // if(i % 2 == 1){

        // }
        if(ll.size()-1 < i) ll.add(new ArrayList<>());
        ll.get(i).add(root.val);
        solver(root.left,i+1);
        solver(root.right,i+1);
    }
    public void solver1(TreeNode root , int i){
        if(root == null) return;
        if(i % 2 == 1){
            root.val = ll.get(i).remove(ll.get(i).size()-1);
        }
        solver1(root.left,i+1);
        solver1(root.right,i+1);
    }
    public TreeNode reverseOddLevels(TreeNode root) {
        ll = new ArrayList<>();
        solver(root , 0);
        solver1(root,0);
        System.out.println(ll);
        return root;
    }
}