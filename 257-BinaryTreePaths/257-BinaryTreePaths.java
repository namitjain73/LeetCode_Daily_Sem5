// Last updated: 7/9/2026, 5:22:46 PM
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
    public void paths(TreeNode root,List<String> ans, List<String> path){
        if(root == null) return;
        path.add(Integer.toString(root.val));
        if(root.left == null && root.right == null){
            ans.add(String.join("->" , path));
        
        }
        else{
            paths(root.left,ans,path);
            paths(root.right,ans,path);
        }
        path.remove(path.size()-1);

        
    }
    public List<String> binaryTreePaths(TreeNode root) {
        
        List<String> ans = new ArrayList<>();
        List<String> path = new ArrayList<>();
        paths(root,ans,path);
        return ans;
    }
}