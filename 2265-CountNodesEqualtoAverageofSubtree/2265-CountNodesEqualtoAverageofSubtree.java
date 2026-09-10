// Last updated: 9/10/2026, 4:50:06 PM
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
18    public int averageOfSubtree(TreeNode root) {
19        ans = 0;
20        solver(root);
21        return(ans);
22        
23    }
24    public int[] solver(TreeNode root){
25        if(root == null) return new int[]{0,0};
26
27        int[] left = solver(root.left);
28        int[] right = solver(root.right);
29
30        int sum = left[0] + right[0] + root.val;
31        int c = left[1] + right[1] + 1;
32        int avg = sum / c;
33        if(avg == root.val) ans++;
34        return new int[]{sum,c};
35
36    }
37}