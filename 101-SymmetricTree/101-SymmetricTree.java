// Last updated: 8/16/2026, 4:25:52 PM
1/**
2 * Definition for a binary tree node.
3 * public class TreeNode {
4 *     int val;
5 *     TreeNode left;
6 *     TreeNode right;
7 *     TreeNode() {}
8 *     TreeNode(int val) { this.val = val; }
9 *     TreeNode(int val, TreeNode left, TreeNode right) {
10 *         this.val = val;
11 *         this.left = left;
12 *         this.right = right;
13 *     }
14 * }
15 */
16class Solution {
17    public boolean isSymmetric(TreeNode root) {
18        return solver(root.left , root.right);
19    }
20    public boolean solver(TreeNode left , TreeNode right){
21        if(left == null && right == null) return true;
22        if(left == null || right == null) return false;
23        if(left.val != right.val) return false;
24
25        boolean l = solver(left.left , right.right);
26        boolean r = solver(left.right , right.left);
27
28        return l && r;
29    }
30}