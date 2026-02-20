// Last updated: 2/20/2026, 11:23:43 AM
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
17    public TreeNode removeLeafNodes(TreeNode root, int t) {
18        TreeNode temp = new TreeNode(0);
19        temp.left = root;
20        solver(temp , t);
21        return temp.left;
22    }
23
24    public void solver(TreeNode root , int t){
25        if(root == null) return;
26        if(root.left == null && root.right == null) return;
27
28        solver(root.left,t);
29        solver(root.right,t);
30        if(root.left != null && root.left.left == null && root.left.right == null && root.left.val == t){
31            root.left = null;
32        }
33        if(root.right != null && root.right.left == null && root.right.right == null && root.right.val == t){
34            root.right = null;
35        }
36    }
37}