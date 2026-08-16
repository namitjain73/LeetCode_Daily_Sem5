// Last updated: 8/16/2026, 10:17:26 PM
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
17    public int maxDepth(TreeNode root) {
18        return solver(root , 1);
19    }
20    public int solver(TreeNode root , int n){
21        if(root == null) return 0;
22        if(root.left == null &&  root.right == null) return n;
23
24        int ans = solver(root.left , n+1);
25        ans = Math.max(ans,solver(root.right ,n+1));
26        return ans;
27    }
28}