// Last updated: 8/16/2026, 4:22:08 PM
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
20        if(p.val != q.val) return false;
21
22        boolean left = isSameTree(p.left , q.left);
23        boolean right = isSameTree(p.right , q.right);
24        return left && right;
25    }
26}