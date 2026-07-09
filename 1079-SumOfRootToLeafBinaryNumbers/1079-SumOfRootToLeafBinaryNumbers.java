// Last updated: 7/9/2026, 5:18:05 PM
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
    public int sumRootToLeaf(TreeNode root){
        StringBuilder sb = new StringBuilder();
        return solver(root , sb);
    }
    public int solver(TreeNode root , StringBuilder sb) {
        if(root == null) return 0;
        if(root.left == null && root.right == null){
            sb.append(root.val);
            int n = number(sb.toString());
            // System.out.println(n);
            sb.deleteCharAt(sb.length()-1);
            return n;
        }

        int sum = 0;
        sb.append(root.val);
        sum += solver(root.left,sb);
        sum += solver(root.right,sb);
        sb.deleteCharAt(sb.length()-1);
        return sum;
    }
    public int number(String s){
        int ans = 0;
        int c = 1;
        for(int i = s.length()-1 ; i >= 0 ; i--){
            if(s.charAt(i) == '1'){
                ans += c;
            }
            c *= 2;
        }
        return ans;
    }
}