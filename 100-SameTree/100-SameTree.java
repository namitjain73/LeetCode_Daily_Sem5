// Last updated: 2/10/2026, 5:51:06 PM
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
17    public boolean isSameTree(TreeNode p, TreeNode q) {
18        if(p == null && q == null) return true;
19        if(p == null || q == null) return false;
20
21        boolean left = isSameTree(p.left , q.left);
22        boolean right = isSameTree(p.right , q.right);
23        return left && right && p.val == q.val;
24    }
25}