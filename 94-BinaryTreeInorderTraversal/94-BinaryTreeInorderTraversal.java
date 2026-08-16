// Last updated: 8/16/2026, 4:02:15 PM
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
17    public List<Integer> inorderTraversal(TreeNode root) {
18        List<Integer> ll = new ArrayList<>();
19        solver(root , ll);
20        return ll;
21    }
22    public void solver(TreeNode root , List<Integer> ll){
23        if(root == null) return;
24
25        solver(root.left,ll);
26        ll.add(root.val);
27        solver(root.right,ll);
28    }
29}