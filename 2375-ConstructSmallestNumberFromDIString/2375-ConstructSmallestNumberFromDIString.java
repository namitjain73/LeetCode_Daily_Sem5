// Last updated: 5/10/2026, 1:14:00 AM
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
17    int ans = 0;
18    public int distributeCoins(TreeNode root) {
19        ans = 0;
20        solver(root);
21        return ans;
22    }
23    public int solver(TreeNode root){
24        if(root == null) return 0;
25        int left = solver(root.left);
26        int right = solver(root.right);
27        ans += Math.abs(right)+Math.abs(left);
28        return root.val+left+right-1;
29    }
30}