// Last updated: 8/21/2026, 10:09:25 PM
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
17    public void flatten(TreeNode root) {
18        solver(root);
19    }
20
21    public TreeNode solver(TreeNode root){
22        if(root == null) return  null;
23        TreeNode dummy = root;
24        TreeNode r = root.right;
25        root.right = solver(root.left);
26        root.left = null;
27        while(root != null && root.right != null){
28            root = root.right;
29            // root.left= null;
30        }
31        root.right = solver(r);
32        // root.left = null;
33        return dummy;
34    }
35}