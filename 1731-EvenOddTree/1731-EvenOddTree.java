// Last updated: 7/9/2026, 5:15:20 PM
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
    public boolean solver(TreeNode root , int i){
        if(root == null) return true;
        if(i % 2 == 0 && root.val % 2 == 0) return false;
        if(i % 2 != 0 && root.val % 2 != 0) return false;

        if(ll.size()-1 < i) ll.add(new ArrayList());
        //System.out.println(ll + " " + root.val);
        if(ll.get(i).size() > 0){
            if(i % 2 != 0){
                if(ll.get(i).get(ll.get(i).size()-1) <= root.val ) return false;
            }else{
                if(ll.get(i).get(ll.get(i).size()-1) >= root.val) return false;
            }
        }
        ll.get(i).add(root.val);

        if(!solver(root.left,i+1)) return false;
        if(!solver(root.right,i+1)) return false;
        return true;
    }
    public boolean isEvenOddTree(TreeNode root) {
        ll = new ArrayList<>();
        // solver(root,0);
        // System.out.println(ll);
        return  solver(root , 0);
        
    }
}