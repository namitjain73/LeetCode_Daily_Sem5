// Last updated: 8/19/2026, 1:43:58 AM
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
17    public List<Integer> rightSideView(TreeNode root) {
18        List<Integer> ll = new ArrayList<>();
19        solver(root,ll,1);
20        return ll;
21    }
22    public void solver(TreeNode root , List<Integer> ll , int n){
23        if(root == null) return ;
24
25
26        if(ll.size() < n) ll.add(root.val);
27
28        solver(root.right , ll , n+1);
29        solver(root.left , ll , n+1);
30    }
31}