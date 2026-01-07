// Last updated: 1/7/2026, 11:33:10 PM
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
17    long sum;
18    long max;
19    int mod = 1_000_000_007;
20    public long total_sum(TreeNode root){
21        if(root == null) return 0;
22        return total_sum(root.left) + total_sum(root.right) + root.val;
23    }
24    public int maxProduct(TreeNode root) {
25        sum = total_sum(root);
26        max = 0;
27        solver(root);
28        return (int)(max%mod);
29    }
30    public long solver(TreeNode root){
31        if(root == null) return 0;
32
33
34        long left = solver(root.left);
35        long right = solver(root.right);
36        long root_sum = left+ right + root.val;
37        max = Math.max(max,root_sum * (sum - root_sum));
38        return root_sum;
39    }
40}