// Last updated: 8/16/2026, 11:14:57 PM
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
17    public List<List<Integer>> levelOrderBottom(TreeNode root) {
18        int n = size(root , 1);
19        List<List<Integer>> ll = new ArrayList<>();
20        solver(root , n , ll);
21        return ll;
22    }
23    public int size(TreeNode root , int n){
24        if(root == null) return 0;
25        return Math.max(size(root.left,n+1),size(root.right,n+1))+1;
26    }
27    public void solver(TreeNode root , int n , List<List<Integer>> ll){
28        if(root == null) return;
29
30
31        while(ll.size() < n) ll.add(new ArrayList<>());
32        ll.get(n-1).add(root.val);
33
34        solver(root.left , n-1 , ll);
35        solver(root.right , n-1 , ll);
36    }
37}