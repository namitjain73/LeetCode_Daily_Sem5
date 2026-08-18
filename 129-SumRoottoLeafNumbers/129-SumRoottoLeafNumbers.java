// Last updated: 8/19/2026, 1:38:44 AM
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
17    public int sumNumbers(TreeNode root) {
18        return solver(root , 0);
19    }
20    public int solver(TreeNode root , int n){
21        if(root == null) return 0;
22        if(root.left == null && root.right == null) return n*10 + root.val;
23
24        int left = solver(root.left , n *10 + root.val);
25        int right= solver(root.right , n*10+root.val);
26        System.out.println(left + " " + right);
27        return left + right;
28
29    }
30}