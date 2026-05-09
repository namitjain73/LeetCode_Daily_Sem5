// Last updated: 5/10/2026, 1:31:29 AM
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
18    public int minCameraCover(TreeNode root) {
19        ans = 0;
20        if(solver(root) == -1) ans++;
21        return ans;
22    }
23    public int solver(TreeNode root){
24        if(root == null) return 0;
25
26
27        int left = solver(root.left);
28        int right = solver(root.right);
29        if(left == -1 || right == -1) {
30            ans++;
31            return 1;
32        }else if(left == 1 || right == 1) return 0;
33        else return -1;
34    }
35}