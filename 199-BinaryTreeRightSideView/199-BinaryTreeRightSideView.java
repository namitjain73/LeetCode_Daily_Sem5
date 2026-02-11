// Last updated: 2/12/2026, 1:55:10 AM
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
18    List<Integer> check;
19    public void solver(TreeNode root, int n){
20        if(root == null) return;
21
22        if(!check.contains(n)){
23            check.add(n);
24            ll.add(root.val);
25        }
26        solver(root.right,n+1);
27        solver(root.left,n+1);
28    }
29    public List<Integer> rightSideView(TreeNode root) {
30        ll =new ArrayList<>();
31        check = new ArrayList<>();
32        solver(root,0);
33        return ll;
34    }
35}