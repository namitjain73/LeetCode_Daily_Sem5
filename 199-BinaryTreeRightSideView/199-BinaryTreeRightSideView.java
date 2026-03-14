// Last updated: 3/15/2026, 12:30:10 AM
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
17    List<Integer> ll;
18    public void solver(TreeNode root, int n){
19        if(root == null) return;
20
21        if(ll.size()-1 < n){
22            ll.add(root.val);
23        }
24        solver(root.right,n+1);
25        solver(root.left,n+1);
26    }
27    public List<Integer> rightSideView(TreeNode root) {
28        ll =new ArrayList<>();
29        solver(root,0);
30        return ll;
31    }
32}