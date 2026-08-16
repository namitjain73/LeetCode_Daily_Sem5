// Last updated: 8/16/2026, 4:30:04 PM
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
17    public List<List<Integer>> levelOrder(TreeNode root) {
18        List<List<Integer>> ll = new ArrayList<>();
19        solver(root , 1 , ll);
20        return ll;
21    }
22    public void solver(TreeNode root , int n , List<List<Integer>> ll){
23        if(root == null) return;
24
25        if(ll.size() < n) ll.add(new ArrayList<>());
26        ll.get(n-1).add(root.val);
27
28        solver(root.left , n+1 , ll);
29        solver(root.right , n+1 , ll);
30    }
31}