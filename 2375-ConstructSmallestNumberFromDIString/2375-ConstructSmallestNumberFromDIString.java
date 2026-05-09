// Last updated: 5/10/2026, 1:30:58 AM
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
17    int camera = 0;
18    public int minCameraCover(TreeNode root) {
19        int c = minCamera(root);
20        if(c == -1 ) camera++;
21        return camera;
22    }
23
24    public int minCamera(TreeNode root){
25        if(root == null) return 0;
26
27
28        int left = minCamera(root.left);
29        int right = minCamera(root.right);
30
31        if(left == -1 || right == -1) {
32            camera++;
33            return 1;
34        }
35        else if(left == 1 || right == 1) return 0;
36        else return -1;
37        // return root;
38    }
39}