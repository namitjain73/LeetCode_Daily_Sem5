// Last updated: 7/9/2026, 5:24:19 PM
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
    public List<List<Integer>> helper(TreeNode root , int t , List<Integer> list , List<List<Integer>> ll,int sum){
        if(root == null) return ll;
        
        sum += root.val;
        list.add(root.val);
        if(root.left ==  null && root.right == null && sum == t) {
            ll.add(new ArrayList<>(list));
            list.remove(list.size()-1);
            return ll;
        }
        
        helper(root.left,t,list,ll,sum);
        helper(root.right,t,list,ll,sum);
        

        
        list.remove(list.size()-1);
        return ll;
    }
    public List<List<Integer>> pathSum(TreeNode root, int t) {
        List<Integer> list = new ArrayList<>();
        List<List<Integer>> ll = new ArrayList<>();
        return helper(root,t,list,ll,0);
    }
}