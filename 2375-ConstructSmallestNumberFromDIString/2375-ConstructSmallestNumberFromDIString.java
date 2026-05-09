// Last updated: 5/9/2026, 8:53:53 PM
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
18    public int sumNumbers(TreeNode root) {
19        ans = 0;
20        return solver(root , 0);
21    }
22    public int solver(TreeNode root , int res){
23        if(root == null){
24            return 0;
25        }
26        if(root.left == null && root.right == null){
27            return res*10+root.val;
28        }
29
30        int n = solver(root.left , res*10+root.val);
31        int m = solver(root.right, res*10+root.val);
32        return n + m;
33    }
34}