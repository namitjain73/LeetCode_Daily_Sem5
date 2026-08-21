// Last updated: 8/21/2026, 10:25:15 PM
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
17    int ans;
18    public int distributeCoins(TreeNode root) {
19        ans = 0;;
20        solver(root);
21        return ans;
22    }
23    public int solver(TreeNode root){
24        if(root == null) return 0;
25
26        int left = solver(root.left);
27        int right = solver(root.right);
28        ans += Math.abs(left) + Math.abs(right);
29        return root.val + left + right - 1;
30    }
31}