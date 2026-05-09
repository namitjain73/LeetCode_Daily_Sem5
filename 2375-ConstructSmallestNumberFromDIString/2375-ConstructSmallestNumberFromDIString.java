// Last updated: 5/9/2026, 8:51:28 PM
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
17    int ans= 0;
18    public void helper(TreeNode root, String s){
19        if(root == null) return;
20        if(root.left == null && root.right == null){
21            s = s + Integer.toString(root.val);
22            System.out.println(s);
23            ans = ans + Integer.parseInt(s);
24        }
25
26
27        helper(root.left , s += root.val);
28        helper(root.right , s);
29
30    }
31    public int sumNumbers(TreeNode root) {
32        ans = 0;
33        helper(root,"");
34        return ans;
35    }
36}