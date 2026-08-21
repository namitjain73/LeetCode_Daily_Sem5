// Last updated: 8/21/2026, 11:11:26 PM
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
17    public TreeNode insertIntoBST(TreeNode root, int val) {
18        if(root == null){
19            TreeNode node = new TreeNode(val);
20            return node;
21        }
22
23        if(root.val > val){
24            root.left = insertIntoBST(root.left , val);
25        }else if(root.val < val){
26            root.right = insertIntoBST(root.right , val);
27        }
28        return root;
29    }
30}