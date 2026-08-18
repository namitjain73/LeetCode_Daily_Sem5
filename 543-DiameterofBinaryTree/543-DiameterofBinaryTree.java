// Last updated: 8/19/2026, 1:58:00 AM
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
17    int n;
18    public int minCameraCover(TreeNode root) {
19        n = 0;
20        int ans = solver(root);
21        return ans == -1 ? n+1 : n;
22    }
23    public int solver(TreeNode root){
24        if(root == null) return 0;
25
26        int left = solver(root.left);
27        int right= solver(root.right);
28
29        if(left == -1 || right == -1){
30            n++;
31            return 1;
32        }else if(left == 1 || right == 1) return 0;
33        else  return -1;
34    }
35}